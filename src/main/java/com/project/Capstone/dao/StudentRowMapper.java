package com.project.Capstone.dao;

import com.project.Capstone.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Student student = new Student(rs.getInt("id"),
                rs.getString("password"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getString("email"),
                rs.getString("phoneNumber"),
                rs.getString("role"),
                rs.getString("imgUrl"),
                rs.getInt("clinicalSupervisorId"));

        return student;
    }
}
