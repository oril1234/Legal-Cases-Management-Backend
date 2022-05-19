package com.project.Capstone.api;

import com.project.Capstone.model.ClinicalSupervisor;
import com.project.Capstone.service.ClinicalSupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/clinicalSupervisor")
@RestController
public class ClinicalSupervisorApi {

    private final ClinicalSupervisorService ClinicalSupervisorService;

    @Autowired
    public ClinicalSupervisorApi(ClinicalSupervisorService ClinicalSupervisorService) {
        this.ClinicalSupervisorService = ClinicalSupervisorService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void insertClinicalSupervisor(@RequestBody ClinicalSupervisor clinicalSupervisor){
        ClinicalSupervisorService.insertClinicalSupervisor(clinicalSupervisor);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<ClinicalSupervisor> getAllClinicalSupervisors() {
        return ClinicalSupervisorService.getAllClinicalSupervisors();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/total")
    public int getNumberOfClinicalSupervisors() {
        return ClinicalSupervisorService.getAllClinicalSupervisors().size();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{id}")
    public ClinicalSupervisor getClinicalSupervisorById(@PathVariable("id") int id) {
        return ClinicalSupervisorService.getClinicalSupervisorById(id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "{id}")
    public int deleteClinicalSupervisorById(@PathVariable("id") int id) {
        return ClinicalSupervisorService.deleteClinicalSupervisor(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "{id}")
    public int updateClinicalSupervisorById(@PathVariable("id") int id, @RequestBody ClinicalSupervisor clinicalSupervisorToUpdate) {
        return ClinicalSupervisorService.updateClinicalSupervisor(id, clinicalSupervisorToUpdate);
    }
}
