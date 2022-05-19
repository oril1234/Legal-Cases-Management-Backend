package com.project.Capstone.dao;

import com.project.Capstone.model.CaseAssignedSupervisorsList;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CaseAssignedSupervisorsRowMapper implements RowMapper<CaseAssignedSupervisorsList> {

    @Override
    public CaseAssignedSupervisorsList mapRow(ResultSet rs, int rowNum) throws SQLException {
        final CaseAssignedSupervisorsList legalCaseAssigned = new CaseAssignedSupervisorsList(rs.getInt("id"),
                rs.getString("studentName"),
                rs.getDate("dateAssigned"),
                rs.getString("status"),
                rs.getString("subject"),
                rs.getString("taskDescription"),
                rs.getDate("dueDate"));

        return legalCaseAssigned;
    }
}
