package com.project.Capstone.api;

import java.io.*;
import java.util.*;

import com.google.common.io.Files;
import com.opencsv.CSVReader;
import com.project.Capstone.model.Person;
import com.project.Capstone.model.Student;
import com.project.Capstone.service.ClientService;
import com.project.Capstone.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.dsig.keyinfo.KeyValue;

@RequestMapping("api/v1/import")
@RestController
public class ImportApi {
    @Value("${file.upload-dir}")
    private String FILE_DIRECTORY;

    private final StudentService studentService;

    @Autowired
    public ImportApi(StudentService studentService) {
        this.studentService = studentService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/upload-file")
    public ResponseEntity<Object> uploadFile(@RequestParam("File") MultipartFile file) throws IOException {
        System.out.println("Uploading file..");
        String extension = Files.getFileExtension(file.getOriginalFilename()).toLowerCase();
        if (!extension.equals("csv")) {
            return new ResponseEntity<Object>("File extension ("+extension+") is not supported.", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        String randString = String.valueOf(Calendar.getInstance().getTimeInMillis());
        String fileName = randString + "." + extension;
        String filePath = FILE_DIRECTORY + fileName;

        File convertFile = new File(filePath);

        if (!convertFile.createNewFile()) {
            return new ResponseEntity<Object>("The File was not uploaded.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();

        Map<String, Object> returnedData = new HashMap<>();
        returnedData.put("file_name", fileName);
        returnedData.put("mapping", getFileMapping(filePath));

        return new ResponseEntity<Object>(returnedData, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/confirm-upload")
    public ResponseEntity<Object> confirmUpload(@RequestParam("File") String fileName) throws IOException {

        Map<String, Object> result = new HashMap<>();
        String filePath = FILE_DIRECTORY + fileName;
        System.out.println("Confirming upload to "+ filePath);

        Map<String, String> mapping = getFileMapping(filePath);

        final List<Student> studentsListToAdd = createStudents(mapping, filePath);
        boolean allAdded = true;
        for(Student s : studentsListToAdd){
            if (studentService.insertStudent(s) == 0) {
                allAdded = false;
            }
        }

        result.put("status", allAdded);

        return new ResponseEntity<Object>(result, HttpStatus.OK);

    }


    private List<Student> createStudents(Map<String, String> mapping, String filePath) throws IOException {

        final List<Student> addedStudents = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            List<String> headers = Arrays.asList(br.readLine().split(","));

            for (Map.Entry<String, String> entry : mapping.entrySet()) {
                final String studentColumn = entry.getKey();
                final String fileColumn = entry.getValue();
                mapping.put(studentColumn, String.valueOf(headers.indexOf(fileColumn)));
            }

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                Student newStudent = new Student(
                        Integer.parseInt(values[Integer.parseInt(mapping.get("id"))]),
                        "password",
                        values[Integer.parseInt(mapping.get("firstName"))],
                        values[Integer.parseInt(mapping.get("lastName"))],
                        values[Integer.parseInt(mapping.get("email"))],
                        values[Integer.parseInt(mapping.get("phoneNumber"))],
                        "Student",
                        "",
                        Integer.parseInt(values[Integer.parseInt(mapping.get("clinicalSupervisorId"))]));

                addedStudents.add(newStudent);
            }
        }

        return addedStudents;
    }


    private Map<String, String> getFileMapping(String filePath) throws IOException
    {
        CSVReader reader = new CSVReader(new FileReader(filePath));
        // if the first line is the header
        String[] fields = reader.readNext();

        return mapColumns(Arrays.asList(fields));

    }

    private Map<String, String> mapColumns(List<String> columns) {
            List<String> studentFields = Arrays.asList("id", "firstName", "lastName", "email", "phoneNumber", "clinicalSupervisorId");
            Map<String, String> mappedFields = new HashMap<String, String>(){
                {
                    for (String field: studentFields) {
                        put(field, "");
                    }
                }
            };

            Map<String, List<String>> possibleMappings = new HashMap<>();
            // ID
            possibleMappings.put("id", Arrays.asList("זהות", "תעודה", "ת.ז", "id", "tz", "t.z"));
            possibleMappings.put("firstName", Arrays.asList("שם פרטי", "פרטי", "first", "first name"));
            possibleMappings.put("lastName", Arrays.asList("משפחה", "family", "sur", "second", "last"));
            possibleMappings.put("email", Arrays.asList("email", "אימייל", "כתובת", "address"));
            possibleMappings.put("phoneNumber", Arrays.asList("טלפון", "פלאפון", "מספר", "phone", "number"));
            possibleMappings.put("clinicalSupervisorId", Arrays.asList("מנחה", "supervisor"));

            // Attempt to map
            boolean skip_col = false;
            for(String col : columns) {
                for (Map.Entry<String, List<String>> entry : possibleMappings.entrySet()) {
                    String studentColumn = entry.getKey();
                    List<String> possibilities = entry.getValue();

                    for (String possibility : possibilities) {
                        if (col.toLowerCase().contains(possibility))
                        {
                            // We have a match!
                            mappedFields.put(studentColumn, col);
                            skip_col = true;
                            break;
                        }
                    }

                    if (skip_col) {
                        skip_col = false;
                        break;
                    }
                }
            }



            return mappedFields;
    }
}
