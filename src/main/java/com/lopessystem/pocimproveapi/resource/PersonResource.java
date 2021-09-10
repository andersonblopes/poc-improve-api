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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

public interface PersonResource extends Versionable {

    @GetMapping("/people")
    ResponseEntity<Page<Person>> findAll(
            @PageableDefault(sort = {"name"}) Pageable pageable,
            @RequestParam MultiValueMap<String, String> parameters);

    @GetMapping("/people/list")
    ResponseEntity<List<Person>> findAll();

    @GetMapping("/people/{personId}")
    ResponseEntity<Person> findById(@PathVariable(name = "personId") Long personId);

    @PostMapping("/admin/people")
    ResponseEntity<Person> create(
            @Valid
            @RequestBody Person person);

    @PutMapping("/people/{personId}")
    ResponseEntity<Person> update(
            @PathVariable(name = "personId") Long personId,
            @Valid
            @RequestBody Person person);

    @DeleteMapping("/people/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(
            @PathVariable(name = "personId") Long personId);

}
