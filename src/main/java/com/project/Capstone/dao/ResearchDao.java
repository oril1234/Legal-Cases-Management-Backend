package com.project.Capstone.dao;

import com.project.Capstone.model.Research;

import java.util.List;

public interface ResearchDao {

    int insertResearch(Research research);

    List<Research> selectAllResearches();

    Research selectResearchById(int id);

    int deleteResearchById(int id);

    int updateResearchById(int id, Research research);

    List<Research> getAllResearchesInChosenClinic(String clinicName);

    int getNumberOfResearchesInAChosenClinic(String clinicName);
}
