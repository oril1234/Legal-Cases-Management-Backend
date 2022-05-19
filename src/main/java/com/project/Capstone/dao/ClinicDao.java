package com.project.Capstone.dao;


import com.project.Capstone.model.Clinic;
import com.project.Capstone.model.LegalCaseCounter;

import java.util.List;

public interface ClinicDao {

    int insertClinic(Clinic clinic);

    List<Clinic> selectAllClinics();

    Clinic selectClinicByName(String clinicName);

    int deleteClinicByName(String clinicName);

    int updateClinicByName(String clinicName, Clinic clinic);

    int getNumberOfActiveClinics();

    List<Clinic> getAllActiveClinicsList();

    List<Clinic> getAllInactiveClinicsList();

    List<LegalCaseCounter> getNumberOfCasesPerStudentByClinic(int supervisorId);

    String getClinicNameBySupervisorId(int clinicalSupervisorId);
}
