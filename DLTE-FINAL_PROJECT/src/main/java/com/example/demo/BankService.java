package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@org.springframework.stereotype.Service
public class BankService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customers> listAll(){
        return jdbcTemplate.query("Select * from customers",new Mapper());
    }

    class Mapper implements RowMapper<Customers> {
        @Override
        public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customers customers = new Customers();
            customers.setCustomer_id(rs.getInt("customer_id"));
            customers.setCustomer_name(rs.getString("customer_name"));
            customers.setAddress(rs.getString("customer_address"));
            customers.setContact(rs.getLong("customer_contact"));
            customers.setStatus(rs.getString("customer_status"));
            customers.setUsername(rs.getString("username"));
            customers.setPassword(rs.getString("password"));


            return customers;

        }

    }
}
