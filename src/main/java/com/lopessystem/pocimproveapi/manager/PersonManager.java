package com.lopessystem.pocimproveapi.manager;

import com.lopessystem.pocimproveapi.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * The interface Person manager.
 */
public interface PersonManager {

    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<Person> findAll(Pageable pageable);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Person> findAll();

    /**
     * Find by id person.
     *
     * @param personId the person id
     * @return the person
     */
    Person findById(Long personId);

    /**
     * Create person.
     *
     * @param person the person
     * @return the person
     */
    @Transactional
    Person create(Person person);

    /**
     * Update person.
     *
     * @param personId the person id
     * @param person   the person
     * @return the person
     */
    @Transactional
    Person update(Long personId, Person person);

    /**
     * Delete.
     *
     * @param personId the person id
     */
    @Transactional
    void delete(Long personId);

    /**
     * Partial update person.
     *
     * @param personId       the person id
     * @param fields         the fields
     * @param servletRequest the servlet request
     * @return the person
     */
    @Transactional
    Person partialUpdate(Long personId, Map<String, Object> fields, HttpServletRequest servletRequest);

}
