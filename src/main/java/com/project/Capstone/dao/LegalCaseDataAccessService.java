package com.project.Capstone.dao;

import com.project.Capstone.model.LegalCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository("legalCaseDao")
public class LegalCaseDataAccessService implements LegalCaseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String legalCasesTableName = "LEGALCASES";

    @Override
    public int insertLegalCase(LegalCase legalCase) {
        return jdbcTemplate.update("INSERT INTO " + legalCasesTableName + " (id,dateAdded,subject,caseType,status," +
                        "courtCaseId,clinicName,clientId) VALUES(?,?,?,?,?,?,?,?)",
                legalCase.getId(), legalCase.getDateAdded(), legalCase.getSubject(), legalCase.getCaseType(),
                legalCase.getStatus(), legalCase.getCourtCaseId(), legalCase.getClinicName(), legalCase.getClientId());
    }

    @Override
    public List<LegalCase> selectAllLegalCases() {
        return jdbcTemplate.query("SELECT * FROM " + legalCasesTableName, new LegalCaseRowMapper());
    }

    @Override
    public LegalCase selectLegalCaseById(int id) {
        return selectAllLegalCases().stream()
               .filter(legalCase -> (legalCase.getId() == id))
               .findFirst()
               .orElseThrow(RuntimeException::new);
    }

    @Override
    public int deleteLegalCaseById(int id) {
        return jdbcTemplate.update("DELETE FROM " + legalCasesTableName + " WHERE id = ?", new Object[] {id});
    }

    /**
     * @param id of the LegalCase we are updating
     * @param legalCase object, updates all of a legalCase's fields
     * @return 1 if the row was updated successfully
     */
    @Override
    public int updateLegalCaseById(int id, LegalCase legalCase) {
        return jdbcTemplate.update("UPDATE " + legalCasesTableName + " SET dateAdded = ?, subject = ?, caseType = ?," +
                        " status = ?, courtCaseId = ?, clinicName = ?, clientId = ?  WHERE id = ?",
                    legalCase.getDateAdded(), legalCase.getSubject(), legalCase.getCaseType(),
                legalCase.getStatus(), legalCase.getCourtCaseId(), legalCase.getClinicName(), legalCase.getClientId(), id);
    }

    /* QUERIES */

    @Override
    public int numberOfClosedCasesThisPastYear() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM " +
                legalCasesTableName + " WHERE status = 'סגור' AND YEAR(dateAdded)=YEAR(DATE_SUB(CURDATE(), INTERVAL 1 YEAR))", Integer.class);
    }

    @Override
    public int numberOfCasesReceivedThisPastYear() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM " +
                legalCasesTableName + " WHERE YEAR(dateAdded)=YEAR(DATE_SUB(CURDATE(), INTERVAL 1 YEAR))", Integer.class);
    }

    @Override
    public int numberOfCasesReceivedThisPastYearByClinic(String clinicName) {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM " +
                legalCasesTableName + " WHERE YEAR(dateAdded)=YEAR(DATE_SUB(CURDATE(), INTERVAL 1 YEAR)) AND " +
                "clinicName LIKE '" + clinicName + "'", Integer.class);
    }

    @Override
    public int numberOfCasesToCourtInAllClinicsBetween2Dates(Date startDate, Date endDate) {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String strStartDate = dateFormat.format(startDate);
        final String strEndDate = dateFormat.format(endDate);

        return jdbcTemplate.queryForObject("SELECT count(*) FROM " + legalCasesTableName +
                " WHERE courtCaseId IS NOT NULL AND (dateAdded BETWEEN '" + strStartDate + "' AND '" + strEndDate + "')", Integer.class);
    }

    @Override
    public int numberOfCasesToCourtInChosenClinicBetween2Dates(Date startDate, Date endDate, String clinicName) {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String strStartDate = dateFormat.format(startDate);
        final String strEndDate = dateFormat.format(endDate);

        return jdbcTemplate.queryForObject("SELECT count(*) FROM " + legalCasesTableName +
                " WHERE courtCaseId IS NOT NULL AND (dateAdded BETWEEN '" + strStartDate + "' AND '" + strEndDate + "') "
                + "AND clinicName LIKE '" + clinicName + "'", Integer.class);
    }

    @Override
    public int numberOfCasesByChosenMonth(int month) {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM " + legalCasesTableName +
                " WHERE MONTH("+ legalCasesTableName + ".dateAdded) = " + month, Integer.class);
    }

    @Override
    public int numberOfCasesByChosenClinic(String clinicName) {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM " + legalCasesTableName +
                " WHERE clinicName LIKE '" + clinicName + "'", Integer.class);
    }

    @Override
    public List<LegalCase> selectAllLegalCasesInCourt() {
        return jdbcTemplate.query("SELECT * FROM " + legalCasesTableName + " WHERE " +
                "courtCaseId NOT LIKE 0 ORDER BY dateAdded DESC", new LegalCaseRowMapper());
    }

    @Override
    public List<LegalCase> selectAllLegalCasesNotInCourt() {
        return jdbcTemplate.query("SELECT * FROM " + legalCasesTableName + " WHERE " +
                "courtCaseId=0 ORDER BY dateAdded DESC", new LegalCaseRowMapper());
    }

    @Override
    public List<LegalCase> selectAllLegalCasesInCourtBelongingToClinic(String clinicName) {
        return jdbcTemplate.query("SELECT * FROM " + legalCasesTableName +
        " WHERE clinicName LIKE '" + clinicName + "' AND courtCaseId IS NOT NULL" +
                " ORDER BY dateAdded DESC", new LegalCaseRowMapper());
    }

    @Override
    public List<LegalCase> selectAllLegalCasesNotInCourtBelongingToClinic(String clinicName) {
        return jdbcTemplate.query("SELECT * FROM " + legalCasesTableName +
                " WHERE clinicName LIKE '" + clinicName + "' AND courtCaseId IS NULL"
                + " ORDER BY dateAdded DESC", new LegalCaseRowMapper());
    }
}
