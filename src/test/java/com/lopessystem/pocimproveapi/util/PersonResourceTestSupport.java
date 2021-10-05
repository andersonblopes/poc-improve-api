package com.lopessystem.pocimproveapi.util;

import com.lopessystem.pocimproveapi.model.Person;
import com.lopessystem.pocimproveapi.model.enumerations.Gender;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * The type Person resource test support.
 */
public class PersonResourceTestSupport {

    /**
     * Create person person.
     *
     * @return the person
     */
    public static Person createPerson() {
        Person person = new Person();
        person.setId(1L);
        person.setCreateDate(OffsetDateTime.now());
        person.setBirthDate(LocalDate.MIN);
        person.setActive(Boolean.TRUE);
        person.setGender(Gender.MALE);
        person.setName("Person Test");
        person.setMotherName("Mother Person Name");

        return person;
    }

    /**
     * Gets person list.
     *
     * @return the person list
     */
    public static List<Person> getPersonList() {
        return Arrays.asList(createPerson());
    }
}
