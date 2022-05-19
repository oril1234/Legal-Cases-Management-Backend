package com.project.Capstone.service;

import com.project.Capstone.dao.PersonDao;
import com.project.Capstone.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("personDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int insertPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Person getPersonById(int id) {
        return personDao.findPersonById(id);
    }

    public String getRoleById(int id) {
        return personDao.getRoleById(id);
    }

    public String getFullNameById(int id) {
        return personDao.getFullNameById(id);
    }

    public int deletePerson(int id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(int id, Person newPerson) {
        return personDao.updatePersonById(id, newPerson);
    }
}
