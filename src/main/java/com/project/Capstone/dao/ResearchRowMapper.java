package com.project.Capstone.dao;

import com.project.Capstone.model.Research;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResearchRowMapper implements RowMapper<Research> {

    @Override
    public Research mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Research research = new Research(rs.getInt("id"),
                rs.getString("clinicName"),
                rs.getString("subject"),
                rs.getString("researchType"),
                rs.getString("status"));

        return research;
    }
}
