package com.project.Capstone.dao;

import com.project.Capstone.model.ClinicalSupervisor;
import com.project.Capstone.model.Student;

import java.util.List;

public interface StudentDao {

    int insertStudent(Student student);

    List<Student> selectAllStudents();

    Student selectStudentById(int id);

    int deleteStudentById(int id);

    int updateStudentById(int id, Student student);

    List<Student> getAllStudentsInChosenClinic(String clinicName);

    ClinicalSupervisor getStudentsClinicalSupervisorDetails(int studentId);

    int getNumberOfStudentsInAllClinics();

    List<Student> getAllStudentsInMyClinic(int studentId);

    int getNumberOfStudentsInMyClinic(int studentId);

    int getNumberOfStudentsInAChosenClinic(String clinicName);

    int getNumberOfLegalCasesInMyClinic(int studentId);
}
