package com.project.Capstone.service;

import com.project.Capstone.dao.ResearchDao;
import com.project.Capstone.model.Research;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResearchService {

    private final ResearchDao researchDao;

    @Autowired
    public ResearchService(@Qualifier("researchDao") ResearchDao researchDao) {
        this.researchDao = researchDao;
    }

    public int insertResearch(Research research){
        return researchDao.insertResearch(research);
    }

    public List<Research> getAllResearches() {
        return researchDao.selectAllResearches();
    }

    public Research getResearchById(int id) {
        return researchDao.selectResearchById(id);
    }

    public int deleteResearch(int id) {
        return researchDao.deleteResearchById(id);
    }

    public int updateResearch(int id, Research newResearch) {
        return researchDao.updateResearchById(id, newResearch);
    }

    public List<Research> getAllResearchesInChosenClinic(String clinicName) {
        return researchDao.getAllResearchesInChosenClinic(clinicName);
    }

    public int getNumberOfResearchesInAChosenClinic(String clinicName) {
        return researchDao.getNumberOfResearchesInAChosenClinic(clinicName);
    }
}
