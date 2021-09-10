package com.lopessystem.pocimproveapi.manager.impl;

import com.lopessystem.pocimproveapi.constants.MessagesConstant;
import com.lopessystem.pocimproveapi.exceptions.EntityBeingUsedException;
import com.lopessystem.pocimproveapi.exceptions.EntityNotFoundException;
import com.lopessystem.pocimproveapi.manager.PersonManager;
import com.lopessystem.pocimproveapi.model.Person;
import com.lopessystem.pocimproveapi.repository.PersonRepository;
import com.lopessystem.pocimproveapi.util.ObjectMerger;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * The type Person manager.
 */
@Slf4j
@Service
@AllArgsConstructor
public class PersonManagerImpl implements PersonManager {

    /**
     * The Person repository.
     */
    private final PersonRepository personRepository;

    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    @Override
    public Page<Person> findAll(Pageable pageable) {
        log.debug("Processing findAll");

        Page<Person> personPage = personRepository.findAll(pageable);

        return new PageImpl<>(personPage.getContent(), pageable, personPage.getTotalElements());
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    @Override
    public List<Person> findAll() {

        log.debug("Processing findAll");

        return personRepository.findAll();
    }

    /**
     * Find by id person.
     *
     * @param personId the person id
     * @return the person
     */
    @Override
    public Person findById(Long personId) {

        log.debug("Processing findById");
        log.debug("Param: {}", personId);

        Person person = personRepository.findById(personId).orElseThrow(() -> new EntityNotFoundException(MessagesConstant.MSG_PERSON_NOT_FOUND, personId));

        return person;
    }

    /**
     * Create person.
     *
     * @param person the person
     * @return the person
     */
    @Override
    public Person create(Person person) {

        log.debug("Processing create");
        log.debug("Param: {}", person);

        person.setId(null);

        return saveOrUpdatePerson(person);
    }


    /**
     * Update person.
     *
     * @param personId the person id
     * @param person   the person
     * @return the person
     */
    @Override
    public Person update(Long personId, Person person) {

        log.debug("Processing update");
        log.debug("Param: {}", personId);
        log.debug("Param: {}", person);

        Person personFound = findById(personId);

        person.setId(personFound.getId());
        person.setCreateDate(personFound.getCreateDate());

        return saveOrUpdatePerson(person);
    }

    /**
     * Delete.
     *
     * @param personId the person id
     */
    @Override
    public void delete(Long personId) {

        log.debug("Processing delete");
        log.debug("Param: {}", personId);

        findById(personId);

        personRepository.deleteById(personId);
    }

    /**
     * Partial update person.
     *
     * @param personId       the person id
     * @param fields         the fields
     * @param servletRequest the servlet request
     * @return the person
     */
    @Override
    public Person partialUpdate(Long personId, Map<String, Object> fields, HttpServletRequest servletRequest) {

        Person person = findById(personId);

        ObjectMerger.mergeRequestBodyToGenericObject(fields, person, Person.class, servletRequest);

        return saveOrUpdatePerson(person);
    }

    /**
     * Save or update person person.
     *
     * @param person the person
     * @return the person
     */
    private Person saveOrUpdatePerson(Person person) {

        log.debug("Processing saveOrUpdatePerson");
        log.debug("Param: {}", person);

        if (person != null) {

            // Prevent database unique constraint violations
            try {

                person = personRepository.save(person);

            } catch (DataIntegrityViolationException exception) {

                log.error("The operation: saveOrUpdatePerson couldn't be processed. {}", exception.getMessage());

                throw new EntityBeingUsedException(String.format(
                        MessagesConstant.MSG_REGISTRY_CONFLICT, person.getName()));
            }

        }

        return person;
    }
}
