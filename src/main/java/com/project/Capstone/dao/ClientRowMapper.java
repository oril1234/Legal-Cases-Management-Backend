package com.project.Capstone.dao;

import com.project.Capstone.model.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Client client = new Client(rs.getInt("id"),
                rs.getString("password"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("email"),
                rs.getString("phoneNumber"),
                rs.getString("role"),
                rs.getString("imgUrl"));

        return client;
    }
}
