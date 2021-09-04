package com.tradeup.addbook.DAO;

import com.tradeup.addbook.api.Person;
import com.tradeup.addbook.rowmapper.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PerDaoImpl implements PerDAO{
    //DB code here in this class

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Person> loadAddress(){
        //logic to retrieve data from database
        String sql = "SELECT * FROM persons";
        List<Person> addresslist = jdbcTemplate.query(sql, new PersonRowMapper());

        return addresslist;
    }

    @Override
    public void savetodb(Person person) {

        Object[] values = {person.getName(),person.getEmail(),person.getGender(),person.getAddress(),person.getCity()};
        String sql = "INSERT into persons(p_name,email,gender,st_address,city) values (?,?,?,?,?)";
        jdbcTemplate.update(sql,values);
        //System.out.println("1 record inserted into db");
    }

    @Override
    public Person getPerson(int id) {

        String sql ="SELECT * FROM persons WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(sql, new PersonRowMapper(), id);

        return person;
    }

    @Override
    public void update(Person person) {
        String sql = "UPDATE persons SET p_name=?, email=?, gender=?, st_address=?, city=?  WHERE id = ?";
        jdbcTemplate.update(sql,person.getName(),person.getEmail(),person.getGender(),person.getAddress(),person.getCity(),person.getId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM persons WHERE id = ?";
        jdbcTemplate.update(sql,id);

    }

}
