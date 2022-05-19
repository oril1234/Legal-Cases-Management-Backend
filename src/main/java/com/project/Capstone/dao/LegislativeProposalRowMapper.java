package com.project.Capstone.dao;

import com.project.Capstone.model.LegislativeProposal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LegislativeProposalRowMapper implements RowMapper<LegislativeProposal> {

    @Override
    public LegislativeProposal mapRow(ResultSet rs, int rowNum) throws SQLException {
        final LegislativeProposal legislativeProposal = new LegislativeProposal(rs.getInt("id"),
                rs.getString("clinicName"),
                rs.getString("subject"),
                rs.getString("proposalType"),
                rs.getString("status"));

        return legislativeProposal;
    }
}
