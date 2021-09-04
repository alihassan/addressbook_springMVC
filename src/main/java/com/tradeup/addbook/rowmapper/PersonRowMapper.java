package com.tradeup.addbook.rowmapper;

import com.tradeup.addbook.api.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int i) throws SQLException {

        Person p = new Person();

        p.setId(rs.getInt(1));
        p.setName(rs.getString(2));
        p.setEmail(rs.getString(3));
        p.setGender(rs.getString(4));
        p.setAddress(rs.getString(5));
        p.setCity(rs.getString(6));

        return p;
    }
}
