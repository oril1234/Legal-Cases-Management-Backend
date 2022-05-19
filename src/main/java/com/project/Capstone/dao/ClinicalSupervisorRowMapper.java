package com.project.Capstone.dao;

import com.project.Capstone.model.ClinicalSupervisor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClinicalSupervisorRowMapper implements RowMapper<ClinicalSupervisor> {

    @Override
    public ClinicalSupervisor mapRow(ResultSet rs, int rowNum) throws SQLException {
        final ClinicalSupervisor ClinicalSupervisor = new ClinicalSupervisor(rs.getInt("id"),
                rs.getString("password"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getString("email"),
                rs.getString("phoneNumber"),
                rs.getString("role"),
                rs.getString("imgUrl"),
                rs.getInt("sinceYear"));

        return ClinicalSupervisor;
    }
}
