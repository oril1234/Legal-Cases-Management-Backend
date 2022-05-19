package com.project.Capstone.dao;

import com.project.Capstone.model.PolicyPaper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PolicyPaperRowMapper implements RowMapper<PolicyPaper> {

    @Override
    public PolicyPaper mapRow(ResultSet rs, int rowNum) throws SQLException {
        final PolicyPaper policyPaper = new PolicyPaper(rs.getInt("id"),
                rs.getString("clinicName"),
                rs.getString("subject"),
                rs.getString("policyType"),
                rs.getString("status"));

        return policyPaper;
    }
}
