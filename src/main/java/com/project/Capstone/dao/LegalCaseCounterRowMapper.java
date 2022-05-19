package com.project.Capstone.dao;

import com.project.Capstone.model.LegalCaseCounter;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LegalCaseCounterRowMapper implements RowMapper<LegalCaseCounter> {

    @Override
    public LegalCaseCounter mapRow(ResultSet rs, int rowNum) throws SQLException {
        final LegalCaseCounter legalCaseCounter = new LegalCaseCounter(rs.getString("name"),
                rs.getInt("amountOfCases"));

        return legalCaseCounter;
    }
}
