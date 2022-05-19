package com.project.Capstone.dao;

import com.project.Capstone.model.LegislativeProposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository("legislativeProposalDao")
public class LegislativeProposalDataAccessService implements LegislativeProposalDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String legislativeProposalesTableName = "LEGISLATIVEPROPOSAL";

    @Override
    public int insertLegislativeProposal(LegislativeProposal legislativeProposal) {
        Random rnd = new Random();
        int randomId = 100000 + rnd.nextInt(900000);
        return jdbcTemplate.update("INSERT INTO " + legislativeProposalesTableName + " (id,clinicName,subject,proposalType,status) VALUES(?,?,?,?,?)",
                randomId, legislativeProposal.getClinicName(), legislativeProposal.getSubject(), legislativeProposal.getProposalType(), legislativeProposal.getStatus());
    }

    @Override
    public List<LegislativeProposal> selectAllLegislativeProposals() {
        return jdbcTemplate.query("SELECT * FROM " + legislativeProposalesTableName, new LegislativeProposalRowMapper());
    }

    @Override
    public LegislativeProposal selectLegislativeProposalById(int id) {
        return selectAllLegislativeProposals().stream()
               .filter(legislativeProposal -> (legislativeProposal.getId() == id))
               .findFirst()
               .orElseThrow(RuntimeException::new);
    }

    @Override
    public int deleteLegislativeProposalById(int id) {
        return jdbcTemplate.update("DELETE FROM " + legislativeProposalesTableName + " WHERE id = ?", new Object[] {id});
    }

    /**
     * @param id of the LegislativeProposal we are updating
     * @param legislativeProposal object, updates all of a legislativeProposal's fields
     * @return 1 if the row was updated successfully
     */
    @Override
    public int updateLegislativeProposalById(int id, LegislativeProposal legislativeProposal) {
        return jdbcTemplate.update("UPDATE " + legislativeProposalesTableName + " SET clinicName = ?, subject = ?, proposalType = ?, status = ? WHERE id = ?",
                legislativeProposal.getClinicName(), legislativeProposal.getSubject(), legislativeProposal.getProposalType(), legislativeProposal.getStatus(), id);
    }

    /*QUERIES*/

    @Override
    public List<LegislativeProposal> getAllLegislativeProposalsInChosenClinic(String clinicName) {
        return jdbcTemplate.query("SELECT * FROM " + legislativeProposalesTableName + " WHERE " +
                "clinicName LIKE '" + clinicName + "' ORDER BY id ASC", new LegislativeProposalRowMapper());
    }

    @Override
    public int getNumberOfLegislativeProposalsInAChosenClinic(String clinicName) {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM " + legislativeProposalesTableName + " WHERE " +
                "clinicName LIKE '" + clinicName + "'", Integer.class);
    }
}
