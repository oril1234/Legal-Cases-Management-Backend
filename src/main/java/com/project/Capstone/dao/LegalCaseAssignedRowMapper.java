package com.project.Capstone.dao;

import com.project.Capstone.model.LegalCaseAssigned;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LegalCaseAssignedRowMapper implements RowMapper<LegalCaseAssigned> {

    @Override
    public LegalCaseAssigned mapRow(ResultSet rs, int rowNum) throws SQLException {
        final LegalCaseAssigned legalCaseAssigned = new LegalCaseAssigned(rs.getInt("legalCaseId"),
                rs.getInt("studentId"),
                rs.getDate("dateAssigned"),
                rs.getString("taskDescription"),
                rs.getDate("dueDate"));

        return legalCaseAssigned;
    }
}
