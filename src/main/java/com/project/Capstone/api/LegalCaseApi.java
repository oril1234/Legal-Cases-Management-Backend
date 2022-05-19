package com.project.Capstone.api;

import com.project.Capstone.model.BetweenDates;
import com.project.Capstone.model.LegalCase;
import com.project.Capstone.service.LegalCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@RequestMapping("api/v1/legalcase")
@RestController
public class LegalCaseApi {

    private final LegalCaseService legalCaseService;

    private final String CLOSED_CASES = "/closedCases";
    private final String CASES_BETWEEN_DATES = "/casesBetween";

    @Autowired
    public LegalCaseApi(LegalCaseService legalCaseService) {
        this.legalCaseService = legalCaseService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void insertLegalCase(@RequestBody LegalCase legalCase){
        legalCaseService.insertLegalCase(legalCase);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<LegalCase> getAllLegalCases() {
        return legalCaseService.getAllLegalCases();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/generateId")
    public int getLegalCaseGeneratedId() {
        final LocalDate date = LocalDate.now();
        final Random r = new Random( System.currentTimeMillis() );
        final int caseId =  ((1 + r.nextInt(2)) * 100 + r.nextInt(2147483));
        return caseId;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{id}")
    public LegalCase getLegalCaseById(@PathVariable("id") int id) {
        return legalCaseService.getLegalCaseById(id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "{id}")
    public int deleteLegalCaseById(@PathVariable("id") int id) {
        return legalCaseService.deleteLegalCase(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "{id}")
    public int updateLegalCaseById(@PathVariable("id") int id, @RequestBody LegalCase legalCaseToUpdate) {
        return legalCaseService.updateLegalCase(id, legalCaseToUpdate);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = CLOSED_CASES)
    public int getNumberOfClosedCasesThisYear() {
        return legalCaseService.getNumberOfClosedCasesThisYear();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/total")
    public int numberOfCasesReceivedThisPastYear() {
        return legalCaseService.numberOfCasesReceivedThisPastYear();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/clinic/totalCasesPastYear")
    public int numberOfCasesReceivedThisPastYearByClinic(@RequestBody String clinicName) {
        return legalCaseService.numberOfCasesReceivedThisPastYearByClinic(clinicName);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = CASES_BETWEEN_DATES)
    public int numberOfCasesToCourtInAllClinicsBetween2Dates(@RequestBody BetweenDates betweenDates) {
        return legalCaseService.numberOfCasesToCourtInAllClinicsBetween2Dates(betweenDates.getStartDate(), betweenDates.getEndDate());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = CASES_BETWEEN_DATES + "/{clinicName}")
    public int numberOfCasesToCourtInChosenClinicBetween2Dates(@PathVariable("clinicName") String clinicName, @RequestBody BetweenDates betweenDates) {
        return legalCaseService.numberOfCasesToCourtInChosenClinicBetween2Dates(betweenDates.getStartDate(), betweenDates.getEndDate(), clinicName);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/month/{monthId}")
    public int getNumberOfCasesByChosenMonth(@PathVariable("monthId") int monthId) {
        return legalCaseService.getNumberOfCasesByChosenMonth(monthId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/clinic/{clinicName}")
    public int getNumberOfCasesByChosenClinic(@PathVariable("clinicName") String clinicName) {
        return legalCaseService.getNumberOfCasesByChosenClinic(clinicName);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/allInCourt")
    public List<LegalCase> selectAllLegalCasesInCourt() {
        return legalCaseService.selectAllLegalCasesInCourt();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/clinic/allCasesInCourt")
    public List<LegalCase> selectAllLegalCasesInCourtBelongingToClinic(@RequestBody String clinicName) {
        return legalCaseService.selectAllLegalCasesInCourtBelongingToClinic(clinicName);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/notInCourt")
    public List<LegalCase> selectAllLegalCasesNotInCourt() {
        return legalCaseService.selectAllLegalCasesNotInCourt();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/clinic/casesNotInCourt")
    public List<LegalCase> selectAllLegalCasesNotInCourtBelongingToClinic(@RequestBody String clinicName) {
        return legalCaseService.selectAllLegalCasesNotInCourtBelongingToClinic(clinicName);
    }
}
