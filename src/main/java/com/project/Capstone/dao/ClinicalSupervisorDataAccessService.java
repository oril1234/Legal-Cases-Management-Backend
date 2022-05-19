package com.project.Capstone.dao;

import com.project.Capstone.model.ClinicalSupervisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ClinicalSupervisorDao")
public class ClinicalSupervisorDataAccessService implements ClinicalSupervisorDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    private final static String ClinicalSupervisorsTableName = "CLINICALSUPERVISORS";

    @Override
    public int insertClinicalSupervisor(ClinicalSupervisor ClinicalSupervisor) {
        return jdbcTemplate.update("INSERT INTO " + ClinicalSupervisorsTableName + " (id,firstname,lastname,email,phoneNumber,imgUrl,sinceYear) VALUES(?,?,?,?,?,?,?)",
                ClinicalSupervisor.getId(), ClinicalSupervisor.getFirstName(), ClinicalSupervisor.getLastName(), ClinicalSupervisor.getEmail(), ClinicalSupervisor.getPhoneNumber(), ClinicalSupervisor.getImgUrl(), ClinicalSupervisor.getSinceYear());
    }

    @Override
    public List<ClinicalSupervisor> selectAllClinicalSupervisors() {
        return jdbcTemplate.query("SELECT * FROM " + ClinicalSupervisorsTableName, new ClinicalSupervisorRowMapper());
    }

    @Override
    public ClinicalSupervisor selectClinicalSupervisorById(int id) {
        return selectAllClinicalSupervisors().stream()
               .filter(ClinicalSupervisor -> (ClinicalSupervisor.getId() == id))
               .findFirst()
               .orElseThrow(RuntimeException::new);
    }

    @Override
    public int deleteClinicalSupervisorById(int id) {
        return jdbcTemplate.update("DELETE FROM " + ClinicalSupervisorsTableName + " WHERE id = ?", new Object[] {id});
    }

    /**
     * @param id of the ClinicalSupervisor we are updating
     * @param ClinicalSupervisor object, updates all of a ClinicalSupervisor's fields
     * @return 1 if the row was updated successfully
     */
    @Override
    public int updateClinicalSupervisorById(int id, ClinicalSupervisor ClinicalSupervisor) {
        return jdbcTemplate.update("UPDATE " + ClinicalSupervisorsTableName + " SET password = ?, firstname = ?, lastname = ?, email = ?, phoneNumber = ?, imgUrl = ?, sinceYear =?  WHERE id = ?",
                bcryptEncoder.encode(ClinicalSupervisor.getPassword()), ClinicalSupervisor.getFirstName(), ClinicalSupervisor.getLastName(), ClinicalSupervisor.getEmail(), ClinicalSupervisor.getPhoneNumber(), ClinicalSupervisor.getImgUrl(), ClinicalSupervisor.getSinceYear(), id);
    }
}
