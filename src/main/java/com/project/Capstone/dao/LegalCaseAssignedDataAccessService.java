package com.project.Capstone.dao;

import com.project.Capstone.model.CaseAssignedSupervisorsList;
import com.project.Capstone.model.LegalCase;
import com.project.Capstone.model.LegalCaseAssigned;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("legalCaseAssignedDao")
public class LegalCaseAssignedDataAccessService implements LegalCaseAssignedDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String legalCaseAssignedsTableName = "LEGALCASEASSIGNED";

    @Override
    public int insertLegalCaseAssigned(LegalCaseAssigned legalCaseAssigned) {
        return jdbcTemplate.update("INSERT INTO " + legalCaseAssignedsTableName + " (legalCaseId,studentId,dateAssigned,taskDescription,dueDate) VALUES(?,?,?,?,?)",
                legalCaseAssigned.getLegalCaseId(), legalCaseAssigned.getStudentId(), legalCaseAssigned.getDateAssigned(), legalCaseAssigned.getTaskDescription(), legalCaseAssigned.getDueDate());
    }

    @Override
    public List<LegalCaseAssigned> selectAllLegalCasesAssigned() {
        return jdbcTemplate.query("SELECT * FROM " + legalCaseAssignedsTableName, new LegalCaseAssignedRowMapper());
    }

    @Override
    public LegalCaseAssigned selectLegalCaseAssignedByCaseId(int id) {
        return selectAllLegalCasesAssigned().stream()
               .filter(legalCaseAssigned -> (legalCaseAssigned.getLegalCaseId() == id))
               .findFirst()
               .orElseThrow(RuntimeException::new);
    }

    @Override
    public int deleteLegalCaseAssignedByCaseIdAndStudentId(int legalCaseId, int studentId) {
        return jdbcTemplate.update("DELETE FROM " + legalCaseAssignedsTableName + " WHERE legalCaseId = ? AND studentId = ?", legalCaseId, studentId);
    }

    /**
     * @param legalCaseId of the LegalCaseAssigned we are updating
     * @param studentId in combination with the student id
     * @param legalCaseAssigned object, updates all of a legalCaseAssigned's fields
     * @return 1 if the row was updated successfully
     */
    @Override
    public int updateLegalCaseAssignedByCaseIdAndStudentId(int legalCaseId, int studentId, LegalCaseAssigned legalCaseAssigned) {
        return jdbcTemplate.update("UPDATE " + legalCaseAssignedsTableName + " SET dateAssigned = ?, taskDescription = ?, dueDate = ? WHERE legalCaseId = ? AND studentId = ?",
                    legalCaseAssigned.getDateAssigned(), legalCaseAssigned.getTaskDescription(), legalCaseAssigned.getDueDate(), legalCaseId, studentId);
    }

    /*QUERIES*/

    @Override
    public List<LegalCase> getAllLegalCasesAssignedToStudent(int studentId) {
        return jdbcTemplate.query("SELECT LEGALCASES.id, LEGALCASES.dateAdded, LEGALCASES.subject, LEGALCASES.caseType," +
                " LEGALCASES.status, LEGALCASES.courtCaseId, LEGALCASES.clinicName, LEGALCASES.clientId" +
                " FROM LEGALCASEASSIGNED, LEGALCASES WHERE LEGALCASES.id=LEGALCASEASSIGNED.legalCaseId" +
                " AND LEGALCASEASSIGNED.studentId=" + studentId, new LegalCaseRowMapper());
    }

    @Override
    public int getNumberOfLegalCasesAssignedToStudent(int studentId) {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM LEGALCASEASSIGNED, LEGALCASES" +
                " WHERE LEGALCASES.id=LEGALCASEASSIGNED.legalCaseId" +
                " AND LEGALCASEASSIGNED.studentId=" + studentId, Integer.class);
    }

    @Override
    public List<CaseAssignedSupervisorsList> getAllCasesAssignedToMyStudents(int supervisorId) {
        return jdbcTemplate.query("SELECT LEGALCASES.id, CONCAT_WS(\" \", STUDENTS.firstname, STUDENTS.lastname) AS studentName," +
                " LEGALCASEASSIGNED.dateAssigned, LEGALCASES.status, LEGALCASES.subject, LEGALCASEASSIGNED.taskDescription, LEGALCASEASSIGNED.dueDate FROM LEGALCASEASSIGNED," +
                " LEGALCASES, STUDENTS, CLINICALSUPERVISORS WHERE LEGALCASES.id=LEGALCASEASSIGNED.legalCaseId AND" +
                " LEGALCASEASSIGNED.studentId=STUDENTS.id AND CLINICALSUPERVISORS.id=STUDENTS.clinicalSupervisorId" +
                " AND CLINICALSUPERVISORS.id=" + supervisorId, new CaseAssignedSupervisorsRowMapper());
    }
}
