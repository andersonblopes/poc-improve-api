package com.lopessystem.pocimproveapi.resource.impl;

import com.lopessystem.pocimproveapi.manager.PersonManager;
import com.lopessystem.pocimproveapi.model.Person;
import com.lopessystem.pocimproveapi.resource.PersonResource;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PersonResourceImpl implements PersonResource {

    private final PersonManager personManager;

    @Override
    public ResponseEntity<Page<Person>> findAll(Pageable pageable, MultiValueMap<String, String> parameters) {
        return ResponseEntity.ok(personManager.findAll(pageable));
    }

    @Override
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(personManager.findAll());
    }

    @Override
    public ResponseEntity<Person> findById(Long personId) {
        return ResponseEntity.ok(personManager.findById(personId));
    }

    @Override
    public ResponseEntity<Person> create(Person person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personManager.create(person));
    }

    @Override
    public ResponseEntity<Person> update(Long personId, Person person) {

        Person personUpdated = personManager.update(personId, person);

        return ResponseEntity.ok(personUpdated);
    }

    @Override
    public void delete(Long personId) {
        personManager.delete(personId);
    }
}
