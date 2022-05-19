package com.project.Capstone.dao;

import com.project.Capstone.model.LegislativeProposal;

import java.util.List;

public interface LegislativeProposalDao {

    int insertLegislativeProposal(LegislativeProposal legislativeProposal);

    List<LegislativeProposal> selectAllLegislativeProposals();

    LegislativeProposal selectLegislativeProposalById(int id);

    int deleteLegislativeProposalById(int id);

    int updateLegislativeProposalById(int id, LegislativeProposal legislativeProposal);

    List<LegislativeProposal> getAllLegislativeProposalsInChosenClinic(String clinicName);

    int getNumberOfLegislativeProposalsInAChosenClinic(String clinicName);
}
