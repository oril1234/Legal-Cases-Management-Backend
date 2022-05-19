package com.project.Capstone.dao;

import com.project.Capstone.model.PolicyPaper;

import java.util.List;

public interface PolicyPaperDao {

    int insertPolicyPaper(PolicyPaper policyPaper);

    List<PolicyPaper> selectAllPolicyPapers();

    PolicyPaper selectPolicyPaperById(int id);

    int deletePolicyPaperById(int id);

    int updatePolicyPaperById(int id, PolicyPaper policyPaper);

    List<PolicyPaper> getAllPolicyPapersInChosenClinic(String clinicName);

    int getNumberOfPolicyPapersInAChosenClinic(String clinicName);
}
