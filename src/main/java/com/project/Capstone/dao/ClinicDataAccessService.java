package com.project.Capstone.dao;

import com.project.Capstone.model.Clinic;
import com.project.Capstone.model.LegalCaseCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ClinicDao")
public class ClinicDataAccessService implements ClinicDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String clinicTableName = "CLINIC";

    @Override
    public int insertClinic(Clinic clinic) {
        return jdbcTemplate.update("INSERT INTO " + clinicTableName + " (clinicName, clinicalSupervisorId, yearFounded, description, active) VALUES(?,?,?,?,?)",
                clinic.getClinicName(), clinic.getClinicalSupervisorId(), clinic.getYearFounded(), clinic.getDescription(), clinic.isActive());
    }

    @Override
    public List<Clinic> selectAllClinics() {
        return jdbcTemplate.query("SELECT * FROM " + clinicTableName, new ClinicRowMapper());
    }

    @Override
    public Clinic selectClinicByName(String clinicName) {
        return selectAllClinics().stream()
               .filter(clinic -> (clinic.getClinicName().equals(clinicName)))
               .findFirst()
               .orElseThrow(RuntimeException::new);
    }

    @Override
    public int deleteClinicByName(String clinicName) {
        return jdbcTemplate.update("DELETE FROM " + clinicTableName + " WHERE clinicName = ?", new Object[] {clinicName});
    }

    /**
     * @param clinicName of the Clinic we are updating
     * @param clinic object, updates all of a clinic's fields
     * @return 1 if the row was updated successfully
     */
    @Override
    public int updateClinicByName(String clinicName, Clinic clinic) {
        return jdbcTemplate.update("UPDATE " + clinicTableName + " SET clinicalSupervisorId = ?, yearFounded = ?, description = ?, active = ? WHERE clinicName = ?",
                    clinic.getClinicalSupervisorId(), clinic.getYearFounded(), clinic.getDescription(), clinic.isActive(), clinicName);
    }

    @Override
    public int getNumberOfActiveClinics() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM " + clinicTableName + " WHERE active=1", Integer.class);
    }

    @Override
    public List<Clinic> getAllActiveClinicsList() {
        return jdbcTemplate.query("SELECT * FROM " + clinicTableName + " WHERE active=1 ORDER BY clinicName", new ClinicRowMapper());
    }

    @Override
    public List<Clinic> getAllInactiveClinicsList() {
        return jdbcTemplate.query("SELECT * FROM " + clinicTableName + " WHERE active=0 ORDER BY clinicName", new ClinicRowMapper());
    }

    @Override
    public List<LegalCaseCounter> getNumberOfCasesPerStudentByClinic(int supervisorId) {
        return jdbcTemplate.query("SELECT CONCAT_WS(\" \", STUDENTS.firstname, STUDENTS.lastname) AS name," +
                " count(LEGALCASEASSIGNED.legalCaseId) AS amountOfCases FROM STUDENTS, CLINICALSUPERVISORS," +
                " CLINIC, LEGALCASEASSIGNED WHERE STUDENTS.clinicalSupervisorId = CLINICALSUPERVISORS.id AND" +
                " STUDENTS.id = LEGALCASEASSIGNED.studentId AND CLINICALSUPERVISORS.id=CLINIC.clinicalSupervisorId" +
                " AND CLINICALSUPERVISORS.id=" + supervisorId + " GROUP BY STUDENTS.id",
                new LegalCaseCounterRowMapper());
    }

    @Override
    public String getClinicNameBySupervisorId(int clinicalSupervisorId) {
        return jdbcTemplate.queryForObject("SELECT clinicName FROM " + clinicTableName + " WHERE clinicalSupervisorId=" + clinicalSupervisorId, String.class);
    }
}
