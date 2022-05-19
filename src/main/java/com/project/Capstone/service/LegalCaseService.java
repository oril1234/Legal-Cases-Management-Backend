package com.project.Capstone.service;

import com.project.Capstone.dao.LegalCaseDao;
import com.project.Capstone.model.LegalCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LegalCaseService {

    private final LegalCaseDao legalCaseDao;

    @Autowired
    public LegalCaseService(@Qualifier("legalCaseDao") LegalCaseDao legalCaseDao) {
        this.legalCaseDao = legalCaseDao;
    }

    public int insertLegalCase(LegalCase legalCase){
        return legalCaseDao.insertLegalCase(legalCase);
    }

    public List<LegalCase> getAllLegalCases() {
        return legalCaseDao.selectAllLegalCases();
    }

    public LegalCase getLegalCaseById(int id) {
        return legalCaseDao.selectLegalCaseById(id);
    }

    public int deleteLegalCase(int id) {
        return legalCaseDao.deleteLegalCaseById(id);
    }

    public int updateLegalCase(int id, LegalCase newLegalCase) {
        return legalCaseDao.updateLegalCaseById(id, newLegalCase);
    }

    /* DASHBOARD */

    public int getNumberOfClosedCasesThisYear() {
        return legalCaseDao.numberOfClosedCasesThisPastYear();
    }

    public int numberOfCasesReceivedThisPastYear() {
        return legalCaseDao.numberOfCasesReceivedThisPastYear();
    }

    public int numberOfCasesReceivedThisPastYearByClinic(String clinicName) {
        return legalCaseDao.numberOfCasesReceivedThisPastYearByClinic(clinicName);
    }

    public int numberOfCasesToCourtInAllClinicsBetween2Dates(Date startDate, Date endDate) {
        return legalCaseDao.numberOfCasesToCourtInAllClinicsBetween2Dates(startDate, endDate);
    }

    public int numberOfCasesToCourtInChosenClinicBetween2Dates(Date startDate, Date endDate, String clinicName) {
        return legalCaseDao.numberOfCasesToCourtInChosenClinicBetween2Dates(startDate, endDate, clinicName);
    }

    public int getNumberOfCasesByChosenMonth(int month) {
        return legalCaseDao.numberOfCasesByChosenMonth(month);
    }

    public int getNumberOfCasesByChosenClinic(String clinicName) {
        return legalCaseDao.numberOfCasesByChosenClinic(clinicName);
    }

    public List<LegalCase> selectAllLegalCasesInCourt() {
        return legalCaseDao.selectAllLegalCasesInCourt();
    }

    public List<LegalCase> selectAllLegalCasesNotInCourt() {
        return legalCaseDao.selectAllLegalCasesNotInCourt();
    }

    public List<LegalCase> selectAllLegalCasesInCourtBelongingToClinic(String clinicName) {
        return legalCaseDao.selectAllLegalCasesInCourtBelongingToClinic(clinicName);
    }

    public List<LegalCase> selectAllLegalCasesNotInCourtBelongingToClinic(String clinicName) {
        return legalCaseDao.selectAllLegalCasesNotInCourtBelongingToClinic(clinicName);
    }
}
