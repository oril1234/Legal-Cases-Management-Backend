package com.project.Capstone.dao;

import com.project.Capstone.model.Clinic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClinicRowMapper implements RowMapper<Clinic> {

    @Override
    public Clinic mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Clinic clinic = new Clinic(rs.getString("clinicName"),
                rs.getInt("clinicalSupervisorId"),
                rs.getString("description"),
                rs.getInt("yearFounded"),
                rs.getBoolean("active"));

        return clinic;
    }
}
