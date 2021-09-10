package com.lopessystem.pocimproveapi.manager.impl;

import com.lopessystem.pocimproveapi.constants.MessagesConstant;
import com.lopessystem.pocimproveapi.exceptions.EntityBeingUsedException;
import com.lopessystem.pocimproveapi.exceptions.EntityNotFoundException;
import com.lopessystem.pocimproveapi.manager.PersonManager;
import com.lopessystem.pocimproveapi.model.Person;
import com.lopessystem.pocimproveapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class PersonManagerImpl implements PersonManager {

    private final PersonRepository personRepository;

    @Override
    public Page<Person> findAll(Pageable pageable) {
        log.debug("Processing findAll");

        Page<Person> personPage = personRepository.findAll(pageable);

        return new PageImpl<>(personPage.getContent(), pageable, personPage.getTotalElements());
    }

    @Override
    public List<Person> findAll() {

        log.debug("Processing findAll");

        return personRepository.findAll();
    }

    @Override
    public Person findById(Long personId) {

        log.debug("Processing findById");
        log.debug("Param: {}", personId);

        Person person = personRepository.findById(personId).orElseThrow(() -> new EntityNotFoundException(MessagesConstant.MSG_PERSON_NOT_FOUND, personId));

        return person;
    }

    @Override
    public Person create(Person person) {

        log.debug("Processing create");
        log.debug("Param: {}", person);

        person.setId(null);

        return saveOrUpdatePerson(person);
    }


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

    @Override
    public void delete(Long personId) {

        log.debug("Processing delete");
        log.debug("Param: {}", personId);

        findById(personId);

        personRepository.deleteById(personId);
    }

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
