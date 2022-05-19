package com.project.Capstone.service;

import com.project.Capstone.dao.LegislativeProposalDao;
import com.project.Capstone.model.LegislativeProposal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegislativeProposalService {

    private final LegislativeProposalDao legislativeProposalDao;

    @Autowired
    public LegislativeProposalService(@Qualifier("legislativeProposalDao") LegislativeProposalDao legislativeProposalDao) {
        this.legislativeProposalDao = legislativeProposalDao;
    }

    public int insertLegislativeProposal(LegislativeProposal legislativeProposal){
        return legislativeProposalDao.insertLegislativeProposal(legislativeProposal);
    }

    public List<LegislativeProposal> getAllLegislativeProposals() {
        return legislativeProposalDao.selectAllLegislativeProposals();
    }

    public LegislativeProposal getLegislativeProposalById(int id) {
        return legislativeProposalDao.selectLegislativeProposalById(id);
    }

    public int deleteLegislativeProposal(int id) {
        return legislativeProposalDao.deleteLegislativeProposalById(id);
    }

    public int updateLegislativeProposal(int id, LegislativeProposal newLegislativeProposal) {
        return legislativeProposalDao.updateLegislativeProposalById(id, newLegislativeProposal);
    }

    public List<LegislativeProposal> getAllLegislativeProposalsInChosenClinic(String clinicName) {
        return legislativeProposalDao.getAllLegislativeProposalsInChosenClinic(clinicName);
    }

    public int getNumberOfLegislativeProposalsInAChosenClinic(String clinicName) {
        return legislativeProposalDao.getNumberOfLegislativeProposalsInAChosenClinic(clinicName);
    }
}
