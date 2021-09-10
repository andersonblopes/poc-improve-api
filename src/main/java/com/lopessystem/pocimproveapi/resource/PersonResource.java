package com.lopessystem.pocimproveapi.resource;

import com.lopessystem.pocimproveapi.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * The interface Person resource.
 */
public interface PersonResource extends Versionable {

    /**
     * Find all response entity.
     *
     * @param pageable   the pageable
     * @param parameters the parameters
     * @return the response entity
     */
    @GetMapping("/people")
    ResponseEntity<Page<Person>> findAll(
            @PageableDefault(sort = {"name"}) Pageable pageable,
            @RequestParam MultiValueMap<String, String> parameters);

    /**
     * Find all response entity.
     *
     * @return the response entity
     */
    @GetMapping("/people/list")
    ResponseEntity<List<Person>> findAll();

    /**
     * Find by id response entity.
     *
     * @param personId the person id
     * @return the response entity
     */
    @GetMapping("/people/{personId}")
    ResponseEntity<Person> findById(@PathVariable(name = "personId") Long personId);

    /**
     * Create response entity.
     *
     * @param person the person
     * @return the response entity
     */
    @PostMapping("/admin/people")
    ResponseEntity<Person> create(
            @Valid
            @RequestBody Person person);

    /**
     * Update response entity.
     *
     * @param personId the person id
     * @param person   the person
     * @return the response entity
     */
    @PutMapping("/people/{personId}")
    ResponseEntity<Person> update(
            @PathVariable(name = "personId") Long personId,
            @Valid
            @RequestBody Person person);

    /**
     * Delete.
     *
     * @param personId the person id
     */
    @DeleteMapping("/people/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(
            @PathVariable(name = "personId") Long personId);

    /**
     * Partial update response entity.
     *
     * @param personId       the person id
     * @param fields         the fields
     * @param servletRequest the servlet request
     * @return the response entity
     */
    @PatchMapping("/people/{personId}")
    ResponseEntity<Person> partialUpdate(
            @PathVariable(name = "personId") Long personId,
            @RequestBody Map<String, Object> fields,
            HttpServletRequest servletRequest);

}
