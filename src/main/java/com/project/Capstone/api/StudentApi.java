package com.project.Capstone.api;

import com.project.Capstone.model.ClinicalSupervisor;
import com.project.Capstone.model.Student;
import com.project.Capstone.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/student")
@RestController
public class StudentApi {

    private final StudentService studentService;

    @Autowired
    public StudentApi(StudentService studentService) {
        this.studentService = studentService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void insertStudent(@RequestBody Student student){
        studentService.insertStudent(student);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "{id}")
    public int deleteStudentById(@PathVariable("id") int id) {
        return studentService.deleteStudent(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "{id}")
    public int updateStudentById(@PathVariable("id") int id, @RequestBody Student studentToUpdate) {
        return studentService.updateStudent(id, studentToUpdate);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{id}/supervisor")
    public ClinicalSupervisor getStudentsClinicalSupervisorDetails(@PathVariable("id") int studentId) {
        return studentService.getStudentsClinicalSupervisorDetails(studentId);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/clinic/getAllClinicsStudents")
    public List<Student> getAllStudentsInChosenClinic(@RequestBody String clinicName) {
        return studentService.getAllStudentsInChosenClinic(clinicName);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/clinic/totalNumberOfStudents")
    public int getNumberOfStudentsInAChosenClinic(@RequestBody String clinicName) {
        return studentService.getNumberOfStudentsInAChosenClinic(clinicName);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/clinic/{studentId}/getall")
    public List<Student> getAllStudentsInMyClinic(@PathVariable("studentId") int studentId) {
        return studentService.getAllStudentsInMyClinic(studentId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/clinic/{studentId}/total")
    public int getNumberOfStudentsInMyClinic(@PathVariable("studentId") int studentId) {
        return studentService.getNumberOfStudentsInMyClinic(studentId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/legalcases/{studentId}/total")
    public int getNumberOfLegalCasesInMyClinic(@PathVariable("studentId") int studentId) {
        return studentService.getNumberOfLegalCasesInMyClinic(studentId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/total")
    public int getNumberOfStudentsInAllClinics() {
        return studentService.getNumberOfStudentsInAllClinics();
    }

}
