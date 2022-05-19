package com.project.Capstone.service;

import com.project.Capstone.dao.ClinicalSupervisorDao;
import com.project.Capstone.model.ClinicalSupervisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicalSupervisorService {

    private final ClinicalSupervisorDao ClinicalSupervisorDao;

    @Autowired
    public ClinicalSupervisorService(@Qualifier("ClinicalSupervisorDao") ClinicalSupervisorDao ClinicalSupervisorDao) {
        this.ClinicalSupervisorDao = ClinicalSupervisorDao;
    }

    public int insertClinicalSupervisor(ClinicalSupervisor ClinicalSupervisor){
        return ClinicalSupervisorDao.insertClinicalSupervisor(ClinicalSupervisor);
    }

    public List<ClinicalSupervisor> getAllClinicalSupervisors() {
        return ClinicalSupervisorDao.selectAllClinicalSupervisors();
    }

    public ClinicalSupervisor getClinicalSupervisorById(int id) {
        return ClinicalSupervisorDao.selectClinicalSupervisorById(id);
    }

    public int deleteClinicalSupervisor(int id) {
        return ClinicalSupervisorDao.deleteClinicalSupervisorById(id);
    }

    public int updateClinicalSupervisor(int id, ClinicalSupervisor newClinicalSupervisor) {
        return ClinicalSupervisorDao.updateClinicalSupervisorById(id, newClinicalSupervisor);
    }
}
