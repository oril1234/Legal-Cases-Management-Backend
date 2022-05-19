package com.project.Capstone.api;

import com.project.Capstone.model.CaseAssignedSupervisorsList;
import com.project.Capstone.model.LegalCase;
import com.project.Capstone.model.LegalCaseAssigned;
import com.project.Capstone.service.LegalCaseAssignedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/caseAssigned")
@RestController
public class LegalCaseAssignedApi {

    private final LegalCaseAssignedService legalCaseAssignedService;

    @Autowired
    public LegalCaseAssignedApi(LegalCaseAssignedService legalCaseAssignedService) {
        this.legalCaseAssignedService = legalCaseAssignedService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void insertLegalCaseAssigned(@RequestBody LegalCaseAssigned legalCaseAssigned){
        legalCaseAssignedService.insertLegalCaseAssigned(legalCaseAssigned);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<LegalCaseAssigned> getAllLegalCaseAssigned() {
        return legalCaseAssignedService.getAllLegalCaseAssigned();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{id}")
    public LegalCaseAssigned selectLegalCaseAssignedByCaseId(@PathVariable("id") int id) {
        return legalCaseAssignedService.selectLegalCaseAssignedByCaseId(id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "case/{caseId}/student/{studentId}")
    public int deleteLegalCaseById(@PathVariable("caseId") int caseId, @PathVariable("studentId") int studentId) {
        return legalCaseAssignedService.deleteLegalCaseAssignedByCaseIdAndStudentId(caseId, studentId);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "case/{caseId}/student/{studentId}")
    public int updateLegalCaseById(@PathVariable("caseId") int caseId, @PathVariable("studentId") int studentId, @RequestBody LegalCaseAssigned legalCaseAssignedToUpdate) {
        return legalCaseAssignedService.updateLegalCaseAssignedByCaseIdAndStudentId(caseId, studentId, legalCaseAssignedToUpdate);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/student/{studentId}")
    public List<LegalCase> getAllLegalCasesAssignedToStudent(@PathVariable("studentId") int studentId) {
        return legalCaseAssignedService.getAllLegalCasesAssignedToStudent(studentId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/total/student/{studentId}")
    public int getNumberOfLegalCasesAssignedToStudent(@PathVariable("studentId") int studentId) {
        return legalCaseAssignedService.getNumberOfLegalCasesAssignedToStudent(studentId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/allCasesAssigedToStudents/{supervisorId}")
    public List<CaseAssignedSupervisorsList> getAllCasesAssignedToMyStudents(@PathVariable("supervisorId") int supervisorId) {
        return legalCaseAssignedService.getAllCasesAssignedToMyStudents(supervisorId);
    }
}
