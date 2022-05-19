package com.project.Capstone.dao;


import com.project.Capstone.model.LegalCase;

import java.util.Date;
import java.util.List;

public interface LegalCaseDao {

    int insertLegalCase(LegalCase legalCase);

    List<LegalCase> selectAllLegalCases();

    LegalCase selectLegalCaseById(int legalCaseId);

    int deleteLegalCaseById(int legalCaseId);

    int updateLegalCaseById(int legalCaseId, LegalCase legalCase);

    int numberOfClosedCasesThisPastYear();

    int numberOfCasesReceivedThisPastYear();

    int numberOfCasesReceivedThisPastYearByClinic(String clinicName);

    int numberOfCasesToCourtInAllClinicsBetween2Dates(Date startDate, Date endDate);

    int numberOfCasesToCourtInChosenClinicBetween2Dates(Date startDate, Date endDate, String clinicName);

    int numberOfCasesByChosenMonth(int month);

    int numberOfCasesByChosenClinic(String clinicName);

    List<LegalCase> selectAllLegalCasesInCourt();

    List<LegalCase> selectAllLegalCasesNotInCourt();

    List<LegalCase> selectAllLegalCasesInCourtBelongingToClinic(String clinicName);

    List<LegalCase> selectAllLegalCasesNotInCourtBelongingToClinic(String clinicName);
}
