package com.lopessystem.pocimproveapi.repository;

import com.lopessystem.pocimproveapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Person repository.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
