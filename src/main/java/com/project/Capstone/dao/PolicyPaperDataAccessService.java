package com.project.Capstone.dao;

import com.project.Capstone.model.PolicyPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository("policyPaperDao")
public class PolicyPaperDataAccessService implements PolicyPaperDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String policyPaperTableName = "POLICYPAPERS";

    @Override
    public int insertPolicyPaper(PolicyPaper policyPaper) {
        Random rnd = new Random();
        int randomId = 100000 + rnd.nextInt(900000);
        return jdbcTemplate.update("INSERT INTO " + policyPaperTableName + " (id,clinicName,subject,policyType,status) VALUES(?,?,?,?,?)",
                randomId, policyPaper.getClinicName(), policyPaper.getSubject(), policyPaper.getPolicyType(), policyPaper.getStatus());
    }

    @Override
    public List<PolicyPaper> selectAllPolicyPapers() {
        return jdbcTemplate.query("SELECT * FROM " + policyPaperTableName, new PolicyPaperRowMapper());
    }

    @Override
    public PolicyPaper selectPolicyPaperById(int id) {
        return selectAllPolicyPapers().stream()
               .filter(policyPaper -> (policyPaper.getId() == id))
               .findFirst()
               .orElseThrow(RuntimeException::new);
    }

    @Override
    public int deletePolicyPaperById(int id) {
        return jdbcTemplate.update("DELETE FROM " + policyPaperTableName + " WHERE id = ?", new Object[] {id});
    }

    /**
     * @param id of the PolicyPaper we are updating
     * @param policyPaper object, updates all of a policyPaper's fields
     * @return 1 if the row was updated successfully
     */
    @Override
    public int updatePolicyPaperById(int id, PolicyPaper policyPaper) {
        return jdbcTemplate.update("UPDATE " + policyPaperTableName + " SET clinicName = ?, subject = ?, policyType = ?, status = ? WHERE id = ?",
                policyPaper.getClinicName(), policyPaper.getSubject(), policyPaper.getPolicyType(), policyPaper.getStatus(), id);
    }

    /*QUERIES*/

    @Override
    public List<PolicyPaper> getAllPolicyPapersInChosenClinic(String clinicName) {
        return jdbcTemplate.query("SELECT * FROM " + policyPaperTableName + " WHERE " +
                "clinicName LIKE '" + clinicName + "' ORDER BY id ASC", new PolicyPaperRowMapper());
    }

    @Override
    public int getNumberOfPolicyPapersInAChosenClinic(String clinicName) {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM " + policyPaperTableName + " WHERE " +
                "clinicName LIKE '" + clinicName + "'", Integer.class);
    }
}
