package com.lopessystem.pocimproveapi.manager.impl;

import com.lopessystem.pocimproveapi.constants.MessagesConstant;
import com.lopessystem.pocimproveapi.exceptions.EntityNotFoundException;
import com.lopessystem.pocimproveapi.manager.PersonManager;
import com.lopessystem.pocimproveapi.model.Person;
import com.lopessystem.pocimproveapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PersonManagerImpl implements PersonManager {

    private final PersonRepository personRepository;

    @Override
    public Person findById(Long personId) {

        Person person = personRepository.findById(personId).orElseThrow(() -> new EntityNotFoundException(MessagesConstant.MSG_PERSON_NOT_FOUND, personId));

        return person;
    }
}
