package com.project.Capstone.dao;

import com.project.Capstone.model.LegalCase;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LegalCaseRowMapper implements RowMapper<LegalCase> {

    @Override
    public LegalCase mapRow(ResultSet rs, int rowNum) throws SQLException {
        final LegalCase legalCase = new LegalCase(rs.getInt("id"),
                rs.getDate("dateAdded"),
                rs.getString("subject"),
                rs.getString("caseType"),
                rs.getString("status"),
                rs.getInt("courtCaseId"),
                rs.getString("clinicName"),
                rs.getInt("clientId"));

        return legalCase;
    }
}
