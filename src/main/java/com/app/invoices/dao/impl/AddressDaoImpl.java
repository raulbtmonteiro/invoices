package com.app.invoices.dao.impl;

import com.app.invoices.dao.AddressDao;
import com.app.invoices.domain.Address;
import org.springframework.jdbc.core.JdbcTemplate;


public class AddressDaoImpl implements AddressDao {

    private final JdbcTemplate jdbcTemplate;

    public AddressDaoImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Address address) {
        jdbcTemplate.update(
                "INSERT INTO addresses (id, street, post_code, city, country) VALUES (?, ?, ?, ?, ?)",
                address.getId(),
                address.getStreet(),
                address.getPostCode(),
                address.getCity(),
                address.getCountry()
        );
    }
}
