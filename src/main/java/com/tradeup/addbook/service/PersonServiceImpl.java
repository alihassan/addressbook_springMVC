package com.tradeup.addbook.service;

import com.tradeup.addbook.DAO.PerDAO;
import com.tradeup.addbook.api.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PerDAO perDAO;

    @Override
    public List<Person> loadAddress() {
        return perDAO.loadAddress();
    }

    @Override
    public void savetodb(Person person) {
        perDAO.savetodb(person);
    }

    @Override
    public Person getPerson(int id) {

        return perDAO.getPerson(id);
    }

    @Override
    public void update(Person person) {
        perDAO.update(person);
    }

    @Override
    public void delete(int id) {
        perDAO.delete(id);
    }

}
