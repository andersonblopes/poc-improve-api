package com.lopessystem.pocimproveapi.manager;

import com.lopessystem.pocimproveapi.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PersonManager {

    Page<Person> findAll(Pageable pageable);

    List<Person> findAll();

    Person findById(Long personId);

    @Transactional
    Person create(Person person);

    @Transactional
    Person update(Long personId, Person person);

    @Transactional
    void delete(Long personId);

}