package com.lopessystem.pocimproveapi.manager;

import com.lopessystem.pocimproveapi.model.Person;

public interface PersonManager {

    Person findById(Long personId);

}
