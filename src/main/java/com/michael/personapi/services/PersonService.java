package com.michael.personapi.services;

import com.michael.personapi.model.Person;
import com.michael.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Page<Person> findAllPersons(Pageable page) {
        return personRepository.findAll(page);
    }

    public void insertPerson(Person person) {
        personRepository.save(person);
    }

    public void updatePerson(Person person) {
        Optional<Person> personUpdate = personRepository.findById(person.getId());
        if (personUpdate.isPresent()) {
            personRepository.save(person);
        }
    }

    public void deletePerson(Long id) {
        Optional<Person> person = personRepository.findById(id);
        person.ifPresent(value -> personRepository.delete(value));
    }

    public Person findPersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElseGet(Person::new);
    }
}
