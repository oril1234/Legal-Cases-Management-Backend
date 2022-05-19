package com.project.Capstone.dao;

import com.project.Capstone.model.ClinicalSupervisor;
import com.project.Capstone.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDao")
public class StudentDataAccessService implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    private final static String studentsTableName = "STUDENTS";

    @Override
    public int insertStudent(Student student) {
        return jdbcTemplate.update("INSERT INTO " + studentsTableName + " (id,firstname,lastname,email,phoneNumber,imgUrl,clinicalSupervisorId) VALUES(?,?,?,?,?,?,?)",
                student.getId(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getPhoneNumber(), student.getImgUrl(), student.getClinicalSupervisorId());
    }

    @Override
    public List<Student> selectAllStudents() {
        return jdbcTemplate.query("SELECT * FROM " + studentsTableName, new StudentRowMapper());
    }

    @Override
    public Student selectStudentById(int id) {
        return selectAllStudents().stream()
               .filter(student -> (student.getId() == id))
               .findFirst()
               .orElseThrow(RuntimeException::new);
    }

    @Override
    public int deleteStudentById(int id) {
        return jdbcTemplate.update("DELETE FROM " + studentsTableName + " WHERE id = ?", new Object[] {id});
    }

    /**
     * @param id of the Student we are updating
     * @param student object, updates all of a student's fields
     * @return 1 if the row was updated successfully
     */
    @Override
    public int updateStudentById(int id, Student student) {
        return jdbcTemplate.update("UPDATE " + studentsTableName + " SET password = ?, firstname = ?,lastname = ?, email = ?, phoneNumber = ?, imgUrl = ?, clinicalSupervisorId=?  WHERE id = ?",
                bcryptEncoder.encode(student.getPassword()), student.getFirstName(), student.getLastName(), student.getEmail(), student.getPhoneNumber(), student.getImgUrl(), student.getClinicalSupervisorId(), id);
    }

    /*QUERIES*/

    @Override
    public List<Student> getAllStudentsInChosenClinic(String clinicName) {
        return jdbcTemplate.query("SELECT STUDENTS.id, STUDENTS.password, STUDENTS.firstname, STUDENTS.lastname, STUDENTS.email, STUDENTS.phoneNumber, STUDENTS.role, STUDENTS.imgUrl," +
                " STUDENTS.clinicalSupervisorId FROM STUDENTS, CLINIC WHERE STUDENTS.clinicalSupervisorId = CLINIC.clinicalSupervisorId " +
                "AND CLINIC.clinicName = '" + clinicName + "' ORDER BY STUDENTS.lastname ASC", new StudentRowMapper());
    }

    @Override
    public ClinicalSupervisor getStudentsClinicalSupervisorDetails(int studentId) {
        return DataAccessUtils.singleResult(jdbcTemplate.query("SELECT CLINICALSUPERVISORS.id, CLINICALSUPERVISORS.password," +
                " CLINICALSUPERVISORS.firstname, CLINICALSUPERVISORS.lastname, CLINICALSUPERVISORS.email," +
                " CLINICALSUPERVISORS.phoneNumber, CLINICALSUPERVISORS.role, CLINICALSUPERVISORS.imgUrl, CLINICALSUPERVISORS.sinceYear" +
                " FROM STUDENTS, CLINICALSUPERVISORS WHERE CLINICALSUPERVISORS.id=STUDENTS.clinicalSupervisorId" +
                " AND STUDENTS.id=" + studentId, new ClinicalSupervisorRowMapper()));
    }

    @Override
    public int getNumberOfStudentsInAllClinics() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM " + studentsTableName, Integer.class);
    }

    @Override
    public List<Student> getAllStudentsInMyClinic(int studentId) {
        return jdbcTemplate.query("SELECT DISTINCT STUDENTS.id, STUDENTS.password, STUDENTS.firstname," +
                " STUDENTS.lastname, STUDENTS.email, STUDENTS.phoneNumber, STUDENTS.role, STUDENTS.imgUrl," +
                " STUDENTS.clinicalSupervisorId FROM STUDENTS, CLINIC, CLINICALSUPERVISORS" +
                " WHERE STUDENTS.clinicalSupervisorId = (SELECT clinicalSupervisorId from" +
                " STUDENTS WHERE id=" + studentId + ") AND CLINIC.clinicalSupervisorId = (SELECT " +
                "clinicalSupervisorId from STUDENTS WHERE id=" + studentId + ") ORDER BY STUDENTS.lastname ASC", new StudentRowMapper());
    }

    @Override
    public int getNumberOfStudentsInMyClinic(int studentId) {
        return jdbcTemplate.queryForObject("SELECT count(DISTINCT STUDENTS.id) FROM STUDENTS," +
                " CLINICALSUPERVISORS, CLINIC WHERE STUDENTS.clinicalSupervisorId = " +
                "(SELECT clinicalSupervisorId from STUDENTS WHERE id=" + studentId + ") AND " +
                "CLINIC.clinicalSupervisorId = (SELECT clinicalSupervisorId from STUDENTS WHERE" +
                " id=" + studentId + ")", Integer.class);
    }

    @Override
    public int getNumberOfStudentsInAChosenClinic(String clinicName) {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM STUDENTS, " +
                "CLINIC WHERE STUDENTS.clinicalSupervisorId = CLINIC.clinicalSupervisorId AND " +
                "CLINIC.clinicName = '" + clinicName + "'", Integer.class);
    }

    @Override
    public int getNumberOfLegalCasesInMyClinic(int studentId) {
        return jdbcTemplate.queryForObject("SELECT count(LEGALCASES.id) AS amountOfCases" +
                " FROM STUDENTS, CLINICALSUPERVISORS, CLINIC, LEGALCASES WHERE" +
                " STUDENTS.clinicalSupervisorId = CLINICALSUPERVISORS.id" +
                " AND CLINICALSUPERVISORS.id=CLINIC.clinicalSupervisorId" +
                " AND CLINIC.clinicName=LEGALCASES.clinicName" +
                " AND STUDENTS.id=" + studentId, Integer.class);
    }
}
