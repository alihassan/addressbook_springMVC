package com.tradeup.addbook.controller;

import com.tradeup.addbook.api.Person;
import com.tradeup.addbook.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class PersonRestController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/persons")
    public List<Person> getPersons(){
        return personService.loadAddress();
    }
    @RequestMapping("/persons/{pid}")
    public Person getPersons(@PathVariable("pid") int id){
        return personService.getPerson(id);
    }
    @RequestMapping(method= RequestMethod.POST, value="/persons")
    public void addPerson(@RequestBody Person person){
        personService.savetodb(person);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/persons/{id}")
    public void updatePerson(@RequestBody Person person, @PathVariable int id){
        person.setId(id);
        personService.update(person);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            value="/persons/{id}")
    public void deletePerson(@PathVariable int id){
        personService.delete(id);
    }
}
