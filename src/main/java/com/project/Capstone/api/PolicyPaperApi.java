package com.project.Capstone.api;

import com.project.Capstone.model.PolicyPaper;
import com.project.Capstone.service.PolicyPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/policyPaper")
@RestController
public class PolicyPaperApi {

    private final PolicyPaperService policyPaperService;

    @Autowired
    public PolicyPaperApi(PolicyPaperService policyPaperService) {
        this.policyPaperService = policyPaperService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void insertPolicyPaper(@RequestBody PolicyPaper policyPaper){
        policyPaperService.insertPolicyPaper(policyPaper);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<PolicyPaper> getAllPolicyPaperes() {
        return policyPaperService.getAllPolicyPapers();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{id}")
    public PolicyPaper getPolicyPaperById(@PathVariable("id") int id) {
        return policyPaperService.getPolicyPaperById(id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "{id}")
    public int deletePolicyPaperById(@PathVariable("id") int id) {
        return policyPaperService.deletePolicyPaper(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "{id}")
    public int updatePolicyPaperById(@PathVariable("id") int id, @RequestBody PolicyPaper policyPaperToUpdate) {
        return policyPaperService.updatePolicyPaper(id, policyPaperToUpdate);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/clinic/{clinicName}")
    public List<PolicyPaper> getAllPolicyPapersInChosenClinic(@PathVariable("clinicName") String clinicName) {
        return policyPaperService.getAllPolicyPapersInChosenClinic(clinicName);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/clinic/total/{clinicName}")
    public int getNumberOfPolicyPapersInAChosenClinic(@PathVariable("clinicName") String clinicName) {
        return policyPaperService.getNumberOfPolicyPapersInAChosenClinic(clinicName);
    }

}
