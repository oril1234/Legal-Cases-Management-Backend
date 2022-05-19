package com.project.Capstone.service;

import com.project.Capstone.dao.LegalCaseAssignedDao;
import com.project.Capstone.model.CaseAssignedSupervisorsList;
import com.project.Capstone.model.LegalCase;
import com.project.Capstone.model.LegalCaseAssigned;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegalCaseAssignedService {

    private final LegalCaseAssignedDao legalCaseAssignedDao;

    @Autowired
    public LegalCaseAssignedService(@Qualifier("legalCaseAssignedDao") LegalCaseAssignedDao legalCaseAssignedDao) {
        this.legalCaseAssignedDao = legalCaseAssignedDao;
    }

    public List<LegalCaseAssigned> getAllLegalCaseAssigned() {
        return legalCaseAssignedDao.selectAllLegalCasesAssigned();
    }

    public LegalCaseAssigned selectLegalCaseAssignedByCaseId(int id) {
        return legalCaseAssignedDao.selectLegalCaseAssignedByCaseId(id);
    }

    public int insertLegalCaseAssigned(LegalCaseAssigned legalCaseAssigned){
        return legalCaseAssignedDao.insertLegalCaseAssigned(legalCaseAssigned);
    }

    public int deleteLegalCaseAssignedByCaseIdAndStudentId(int legalCaseId, int studentId) {
        return legalCaseAssignedDao.deleteLegalCaseAssignedByCaseIdAndStudentId(legalCaseId, studentId);
    }

    public int updateLegalCaseAssignedByCaseIdAndStudentId(int legalCaseId, int studentId, LegalCaseAssigned newLegalCaseAssigned) {
        return legalCaseAssignedDao.updateLegalCaseAssignedByCaseIdAndStudentId(legalCaseId, studentId, newLegalCaseAssigned);
    }

    public List<LegalCase> getAllLegalCasesAssignedToStudent(int studentId) {
        return legalCaseAssignedDao.getAllLegalCasesAssignedToStudent(studentId);
    }

    public int getNumberOfLegalCasesAssignedToStudent(int studentId) {
        return legalCaseAssignedDao.getNumberOfLegalCasesAssignedToStudent(studentId);
    }

    public List<CaseAssignedSupervisorsList> getAllCasesAssignedToMyStudents(int supervisorId){
        return legalCaseAssignedDao.getAllCasesAssignedToMyStudents(supervisorId);
    }
}
