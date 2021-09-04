package com.tradeup.addbook.service;

import com.tradeup.addbook.api.Person;

import java.util.List;
//Controller-->service--->dao-->Database
public interface PersonService {

    List<Person> loadAddress();
    void savetodb(Person person);
    Person getPerson(int id);
    void update(Person person);
    void delete(int id);
}
