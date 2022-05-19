package com.project.Capstone.dao;

import com.project.Capstone.model.ClinicalSupervisor;

import java.util.List;

public interface ClinicalSupervisorDao {
    
    int insertClinicalSupervisor(ClinicalSupervisor ClinicalSupervisor);

    List<ClinicalSupervisor> selectAllClinicalSupervisors();

    ClinicalSupervisor selectClinicalSupervisorById(int id);

    int deleteClinicalSupervisorById(int id);

    int updateClinicalSupervisorById(int id, ClinicalSupervisor ClinicalSupervisor);
}
