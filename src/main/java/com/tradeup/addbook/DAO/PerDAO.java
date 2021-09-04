package com.tradeup.addbook.DAO;

import com.tradeup.addbook.api.Person;

import java.util.List;

public interface PerDAO {

    List<Person> loadAddress();
    void savetodb(Person person);
    Person getPerson(int id);
    void update(Person person);
    void delete(int id);
}
