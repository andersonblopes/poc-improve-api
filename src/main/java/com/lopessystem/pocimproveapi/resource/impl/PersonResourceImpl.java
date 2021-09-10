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

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * The type Person resource.
 */
@RestController
@AllArgsConstructor
public class PersonResourceImpl implements PersonResource {

    /**
     * The Person manager.
     */
    private final PersonManager personManager;

    /**
     * Find all response entity.
     *
     * @param pageable   the pageable
     * @param parameters the parameters
     * @return the response entity
     */
    @Override
    public ResponseEntity<Page<Person>> findAll(Pageable pageable, MultiValueMap<String, String> parameters) {
        return ResponseEntity.ok(personManager.findAll(pageable));
    }

    /**
     * Find all response entity.
     *
     * @return the response entity
     */
    @Override
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(personManager.findAll());
    }

    /**
     * Find by id response entity.
     *
     * @param personId the person id
     * @return the response entity
     */
    @Override
    public ResponseEntity<Person> findById(Long personId) {
        return ResponseEntity.ok(personManager.findById(personId));
    }

    /**
     * Create response entity.
     *
     * @param person the person
     * @return the response entity
     */
    @Override
    public ResponseEntity<Person> create(Person person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personManager.create(person));
    }

    /**
     * Update response entity.
     *
     * @param personId the person id
     * @param person   the person
     * @return the response entity
     */
    @Override
    public ResponseEntity<Person> update(Long personId, Person person) {

        Person personUpdated = personManager.update(personId, person);

        return ResponseEntity.ok(personUpdated);
    }

    /**
     * Delete.
     *
     * @param personId the person id
     */
    @Override
    public void delete(Long personId) {
        personManager.delete(personId);
    }

    /**
     * Partial update response entity.
     *
     * @param personId       the person id
     * @param fields         the fields
     * @param servletRequest the servlet request
     * @return the response entity
     */
    @Override
    public ResponseEntity<Person> partialUpdate(Long personId, Map<String, Object> fields, HttpServletRequest servletRequest) {
        return ResponseEntity.ok(personManager.partialUpdate(personId, fields, servletRequest));
    }
}
