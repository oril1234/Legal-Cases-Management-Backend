package com.project.Capstone.dao;


import com.project.Capstone.model.CaseAssignedSupervisorsList;
import com.project.Capstone.model.LegalCase;
import com.project.Capstone.model.LegalCaseAssigned;

import java.util.List;

public interface LegalCaseAssignedDao {

    int insertLegalCaseAssigned(LegalCaseAssigned legalCaseAssigned);

    List<LegalCaseAssigned> selectAllLegalCasesAssigned();

    LegalCaseAssigned selectLegalCaseAssignedByCaseId(int legalCaseId);

    int deleteLegalCaseAssignedByCaseIdAndStudentId(int legalCaseId, int studentId);

    int updateLegalCaseAssignedByCaseIdAndStudentId(int legalCaseId, int studentId, LegalCaseAssigned legalCase);

    List<LegalCase> getAllLegalCasesAssignedToStudent(int studentId);

    int getNumberOfLegalCasesAssignedToStudent(int studentId);

    List<CaseAssignedSupervisorsList> getAllCasesAssignedToMyStudents(int supervisorId);
}
