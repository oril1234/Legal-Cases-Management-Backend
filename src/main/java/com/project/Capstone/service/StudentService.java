package com.project.Capstone.service;

import com.project.Capstone.dao.StudentDao;
import com.project.Capstone.model.ClinicalSupervisor;
import com.project.Capstone.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentDao studentDao;

    @Autowired
    public StudentService(@Qualifier("studentDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public int insertStudent(Student student){
        return studentDao.insertStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();
    }

    public Student getStudentById(int id) {
        return studentDao.selectStudentById(id);
    }

    public int deleteStudent(int id) {
        return studentDao.deleteStudentById(id);
    }

    public int updateStudent(int id, Student newStudent) {
        return studentDao.updateStudentById(id, newStudent);
    }

    public List<Student> getAllStudentsInChosenClinic(String clinicName) {
        return studentDao.getAllStudentsInChosenClinic(clinicName);
    }

    public ClinicalSupervisor getStudentsClinicalSupervisorDetails(int studentId) {
        return studentDao.getStudentsClinicalSupervisorDetails(studentId);
    }

    public int getNumberOfStudentsInAllClinics() {
        return studentDao.getNumberOfStudentsInAllClinics();
    }

    public List<Student> getAllStudentsInMyClinic(int studentId) {
        return studentDao.getAllStudentsInMyClinic(studentId);
    }

    public int getNumberOfStudentsInMyClinic(int studentId) {
        return studentDao.getNumberOfStudentsInMyClinic(studentId);
    }

    public int getNumberOfStudentsInAChosenClinic(String clinicName) {
        return studentDao.getNumberOfStudentsInAChosenClinic(clinicName);
    }

    public int getNumberOfLegalCasesInMyClinic(int studentId) {
        return studentDao.getNumberOfLegalCasesInMyClinic(studentId);
    }
}
