package com.project.Capstone.dao;

import com.project.Capstone.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("personDao")
public class PersonDataAccessService implements PersonDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String personTableName = "PERSON";

    @Override
    public int insertPerson(Person person) {
        return jdbcTemplate.update("INSERT INTO " + personTableName + " (id,firstname,lastname,email) VALUES(?,?,?,?)",
                person.getId(), person.getFirstName(), person.getLastName(), person.getEmail());
    }

    @Override
    public List<Person> selectAllPeople() {
        return jdbcTemplate.query("SELECT CLINICALSUPERVISORS.id, CLINICALSUPERVISORS.password, CLINICALSUPERVISORS.firstname," +
                " CLINICALSUPERVISORS.lastname, CLINICALSUPERVISORS.email, CLINICALSUPERVISORS.phoneNumber, CLINICALSUPERVISORS.role, CLINICALSUPERVISORS.imgUrl FROM" +
                " CLINICALSUPERVISORS UNION SELECT STUDENTS.id, STUDENTS.password, STUDENTS.firstname, STUDENTS.lastname, STUDENTS.email," +
                " STUDENTS.phoneNumber, STUDENTS.role, STUDENTS.imgUrl FROM STUDENTS ", new PersonRowMapper());
    }

    @Override
    public Person findPersonById(int id) {
        return selectAllPeople().stream()
                .filter(person -> (person.getId() == id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public String getRoleById(int id) {
        return selectAllPeople().stream()
                .filter(person -> (person.getId() == id))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getRole();
    }

    @Override
    public String getFullNameById(int id) {
        return jdbcTemplate.queryForObject("SELECT Name FROM (SELECT CONCAT_WS(\" \",STUDENTS.firstname, STUDENTS.lastname) AS Name, id FROM STUDENTS " +
                "UNION " +
                "SELECT CONCAT_WS(\" \",CLINICALSUPERVISORS.firstname, CLINICALSUPERVISORS.lastname) AS Name, id FROM CLINICALSUPERVISORS) AS NameList WHERE id= " + id, String.class);
    }

    @Override
    public int deletePersonById(int id) {
        return jdbcTemplate.update("DELETE FROM " + personTableName + " WHERE id = ?", new Object[] {id});
    }

    /**
     * @param id of the Person we are updating
     * @param person object, updates all of a person's fields
     * @return 1 if the row was updated successfully
     */
    @Override
    public int updatePersonById(int id, Person person) {
        return jdbcTemplate.update("UPDATE " + personTableName + " SET firstname = ?,lastname = ?, email = ? WHERE id = ?",
                    person.getFirstName(), person.getLastName(), person.getEmail(), id);
    }
}
