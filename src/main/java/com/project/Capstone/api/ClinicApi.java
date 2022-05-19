package com.project.Capstone.api;

import com.project.Capstone.model.Clinic;
import com.project.Capstone.model.LegalCaseCounter;
import com.project.Capstone.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("api/v1/clinic")
@RestController
public class ClinicApi {

    private final ClinicService clinicService;

    @Autowired
    public ClinicApi(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void insertClinic(@RequestBody Clinic clinic){
        clinicService.insertClinic(clinic);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Clinic> getAllClinics() {
        return clinicService.getAllClinics();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{clinicName}")
    public Clinic getClinicById(@PathVariable("clinicName") String clinicName) {
        return clinicService.getClinicByName(clinicName);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "{clinicName}")
    public int deleteClinicById(@PathVariable("clinicName") String clinicName) {
        return clinicService.deleteClinic(clinicName);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "{clinicName}")
    public int updateClinicById(@PathVariable("clinicName") String clinicName, @RequestBody Clinic clinicToUpdate) {
        return clinicService.updateClinic(clinicName, clinicToUpdate);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/total/active")
    public int getNumberOfActiveClinics() {
        return clinicService.getNumberOfActiveClinics();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/active")
    public List<Clinic> getAllActiveClinicsList() {
        return clinicService.getAllActiveClinicsList();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/inactive")
    public List<Clinic> getAllInactiveClinicsList() {
        return clinicService.getAllInactiveClinicsList();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{supervisorId}/legalCasesPerStudent")
    public List<LegalCaseCounter> getNumberOfCasesPerStudentByClinic(@PathVariable("supervisorId") int supervisorId) {
        return clinicService.getNumberOfCasesPerStudentByClinic(supervisorId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/name/{clinicalSupervisorId}")
    public List<String> getClinicNameBySupervisorId(@PathVariable("clinicalSupervisorId") int clinicalSupervisorId) {
        return Arrays.asList(clinicService.getClinicNameBySupervisorId(clinicalSupervisorId));
    }
}
