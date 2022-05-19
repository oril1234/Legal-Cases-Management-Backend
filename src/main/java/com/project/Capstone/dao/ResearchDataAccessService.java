package com.project.Capstone.dao;

import com.project.Capstone.model.Research;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository("researchDao")
public class ResearchDataAccessService implements ResearchDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String researchesTableName = "RESEARCH";

    @Override
    public int insertResearch(Research research) {
        Random rnd = new Random();
        int randomId = 100000 + rnd.nextInt(900000);
        return jdbcTemplate.update("INSERT INTO " + researchesTableName + " (id,clinicName,subject,researchType,status) VALUES(?,?,?,?,?)",
                randomId, research.getClinicName(), research.getSubject(), research.getResearchType(), research.getStatus());
    }

    @Override
    public List<Research> selectAllResearches() {
        return jdbcTemplate.query("SELECT * FROM " + researchesTableName, new ResearchRowMapper());
    }

    @Override
    public Research selectResearchById(int id) {
        return selectAllResearches().stream()
               .filter(research -> (research.getId() == id))
               .findFirst()
               .orElseThrow(RuntimeException::new);
    }

    @Override
    public int deleteResearchById(int id) {
        return jdbcTemplate.update("DELETE FROM " + researchesTableName + " WHERE id = ?", new Object[] {id});
    }

    /**
     * @param id of the Research we are updating
     * @param research object, updates all of a research's fields
     * @return 1 if the row was updated successfully
     */
    @Override
    public int updateResearchById(int id, Research research) {
        return jdbcTemplate.update("UPDATE " + researchesTableName + " SET clinicName = ?, subject = ?, researchType = ?, status = ? WHERE id = ?",
                research.getClinicName(), research.getSubject(), research.getResearchType(), research.getStatus(), id);
    }

    /*QUERIES*/

    @Override
    public List<Research> getAllResearchesInChosenClinic(String clinicName) {
        return jdbcTemplate.query("SELECT * FROM " + researchesTableName + " WHERE " +
                "clinicName LIKE '" + clinicName + "' ORDER BY id ASC", new ResearchRowMapper());
    }

    @Override
    public int getNumberOfResearchesInAChosenClinic(String clinicName) {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM " + researchesTableName + " WHERE " +
                "clinicName LIKE '" + clinicName + "'", Integer.class);
    }
}
