package com.project.Capstone.service;

import com.project.Capstone.dao.PolicyPaperDao;
import com.project.Capstone.model.PolicyPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyPaperService {

    private final PolicyPaperDao policyPaperDao;

    @Autowired
    public PolicyPaperService(@Qualifier("policyPaperDao") PolicyPaperDao policyPaperDao) {
        this.policyPaperDao = policyPaperDao;
    }

    public int insertPolicyPaper(PolicyPaper policyPaper){
        return policyPaperDao.insertPolicyPaper(policyPaper);
    }

    public List<PolicyPaper> getAllPolicyPapers() {
        return policyPaperDao.selectAllPolicyPapers();
    }

    public PolicyPaper getPolicyPaperById(int id) {
        return policyPaperDao.selectPolicyPaperById(id);
    }

    public int deletePolicyPaper(int id) {
        return policyPaperDao.deletePolicyPaperById(id);
    }

    public int updatePolicyPaper(int id, PolicyPaper newPolicyPaper) {
        return policyPaperDao.updatePolicyPaperById(id, newPolicyPaper);
    }

    public List<PolicyPaper> getAllPolicyPapersInChosenClinic(String clinicName) {
        return policyPaperDao.getAllPolicyPapersInChosenClinic(clinicName);
    }

    public int getNumberOfPolicyPapersInAChosenClinic(String clinicName) {
        return policyPaperDao.getNumberOfPolicyPapersInAChosenClinic(clinicName);
    }
}
