package com.michael.personapi.controller;

import com.michael.personapi.model.Person;
import com.michael.personapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Person> findAll(final Pageable page) {
        return personService.findAllPersons(page);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person findById(@PathVariable Long id) {
        return personService.findPersonById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String insert(@RequestBody Person person) {
        personService.insertPerson(person);
        return "{\"status\": 201, \"message\": \"created successfully\"}";
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String update(@RequestBody Person person) {
        personService.updatePerson(person);
        return "{\"status\": 201, \"message\": \"updated successfully\"}";
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String delete(@PathVariable Long id) {
        personService.deletePerson(id);
        return "{\"status\": 202, \"message\": \"deleted successfully\"}";
    }
}
