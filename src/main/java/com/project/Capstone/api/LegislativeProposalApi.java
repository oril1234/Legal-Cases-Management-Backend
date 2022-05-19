package com.project.Capstone.api;

import com.project.Capstone.model.LegislativeProposal;
import com.project.Capstone.service.LegislativeProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/legProposal")
@RestController
public class LegislativeProposalApi {

    private final LegislativeProposalService legislativeProposalService;

    @Autowired
    public LegislativeProposalApi(LegislativeProposalService legislativeProposalService) {
        this.legislativeProposalService = legislativeProposalService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void insertLegislativeProposal(@RequestBody LegislativeProposal legislativeProposal){
        legislativeProposalService.insertLegislativeProposal(legislativeProposal);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<LegislativeProposal> getAllLegislativeProposales() {
        return legislativeProposalService.getAllLegislativeProposals();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{id}")
    public LegislativeProposal getLegislativeProposalById(@PathVariable("id") int id) {
        return legislativeProposalService.getLegislativeProposalById(id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "{id}")
    public int deleteLegislativeProposalById(@PathVariable("id") int id) {
        return legislativeProposalService.deleteLegislativeProposal(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "{id}")
    public int updateLegislativeProposalById(@PathVariable("id") int id, @RequestBody LegislativeProposal legislativeProposalToUpdate) {
        return legislativeProposalService.updateLegislativeProposal(id, legislativeProposalToUpdate);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/clinic/{clinicName}")
    public List<LegislativeProposal> getAllLegislativeProposalsInChosenClinic(@PathVariable("clinicName") String clinicName) {
        return legislativeProposalService.getAllLegislativeProposalsInChosenClinic(clinicName);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/clinic/total/{clinicName}")
    public int getNumberOfLegislativeProposalsInAChosenClinic(@PathVariable("clinicName") String clinicName) {
        return legislativeProposalService.getNumberOfLegislativeProposalsInAChosenClinic(clinicName);
    }

}
