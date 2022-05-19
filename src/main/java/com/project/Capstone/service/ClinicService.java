package com.project.Capstone.service;

import com.project.Capstone.dao.ClinicDao;
import com.project.Capstone.model.Clinic;
import com.project.Capstone.model.LegalCaseCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicService {

    private final ClinicDao clinicDao;

    @Autowired
    public ClinicService(@Qualifier("ClinicDao") ClinicDao clinicDao) {
        this.clinicDao = clinicDao;
    }

    public int insertClinic(Clinic clinic){
        return clinicDao.insertClinic(clinic);
    }

    public List<Clinic> getAllClinics() {
        return clinicDao.selectAllClinics();
    }

    public Clinic getClinicByName(String clinicName) {
        return clinicDao.selectClinicByName(clinicName);
    }

    public int deleteClinic(String clinicName) {
        return clinicDao.deleteClinicByName(clinicName);
    }

    public int updateClinic(String clinicName, Clinic newClinic) {
        return clinicDao.updateClinicByName(clinicName, newClinic);
    }

    public int getNumberOfActiveClinics() {
        return clinicDao.getNumberOfActiveClinics();
    }

    public List<Clinic> getAllActiveClinicsList() {
        return clinicDao.getAllActiveClinicsList();
    }

    public List<Clinic> getAllInactiveClinicsList() {
        return clinicDao.getAllInactiveClinicsList();
    }

    public List<LegalCaseCounter> getNumberOfCasesPerStudentByClinic(int supervisorId){
        return clinicDao.getNumberOfCasesPerStudentByClinic(supervisorId);
    }

    public String getClinicNameBySupervisorId(int clinicalSupervisorId){
        return clinicDao.getClinicNameBySupervisorId(clinicalSupervisorId);
    }
}
