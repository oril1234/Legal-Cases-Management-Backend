package com.project.Capstone.api;

import com.project.Capstone.model.Research;
import com.project.Capstone.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/research")
@RestController
public class ResearchApi {

    private final ResearchService researchService;

    @Autowired
    public ResearchApi(ResearchService researchService) {
        this.researchService = researchService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void insertResearch(@RequestBody Research research){
        researchService.insertResearch(research);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Research> getAllResearches() {
        return researchService.getAllResearches();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{id}")
    public Research getResearchById(@PathVariable("id") int id) {
        return researchService.getResearchById(id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "{id}")
    public int deleteResearchById(@PathVariable("id") int id) {
        return researchService.deleteResearch(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "{id}")
    public int updateResearchById(@PathVariable("id") int id, @RequestBody Research researchToUpdate) {
        return researchService.updateResearch(id, researchToUpdate);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/clinic/{clinicName}")
    public List<Research> getAllResearchesInChosenClinic(@PathVariable("clinicName") String clinicName) {
        return researchService.getAllResearchesInChosenClinic(clinicName);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/clinic/total/{clinicName}")
    public int getNumberOfResearchesInAChosenClinic(@PathVariable("clinicName") String clinicName) {
        return researchService.getNumberOfResearchesInAChosenClinic(clinicName);
    }

}
