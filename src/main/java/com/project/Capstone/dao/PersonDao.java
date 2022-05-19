package com.project.Capstone.dao;

import com.project.Capstone.model.Person;

import java.util.List;

public interface PersonDao {
    //The interface where we define the operations allowed for anyone who implements this interface

    int insertPerson(Person person);

    List<Person> selectAllPeople();

    Person findPersonById(int id);

    String getRoleById(int id);

    String getFullNameById(int id);

    int deletePersonById(int id);

    int updatePersonById(int id, Person person);
}
