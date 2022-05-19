package com.project.Capstone.api;

import com.project.Capstone.model.Person;
import com.project.Capstone.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonApi {

    private final PersonService personService;

    @Autowired
    public PersonApi(PersonService personService) {
        this.personService = personService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void insertPerson(@RequestBody Person person){
        personService.insertPerson(person);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") int id) {
        return personService.getPersonById(id);
    }

    /*
    Method returns persons role by their ID
     */
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/role/{id}")
    public List<String> getRoleById(@PathVariable("id") int id) {
        return Arrays.asList(personService.getRoleById(id));
    }

    /*
    Method returns persons name by their ID
     */
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/fullName/{id}")
    public List<String> getFullNameById(@PathVariable("id") int id) {
        return Arrays.asList(personService.getFullNameById(id));
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "{id}")
    public int deletePersonById(@PathVariable("id") int id) {
        return personService.deletePerson(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "{id}")
    public int updatePersonById(@PathVariable("id") int id, @RequestBody Person personToUpdate) {
        return personService.updatePerson(id, personToUpdate);
    }
}
