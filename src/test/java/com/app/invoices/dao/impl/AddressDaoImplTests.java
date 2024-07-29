package com.app.invoices.dao.impl;

import com.app.invoices.TestDataUtil;
import com.app.invoices.domain.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AddressDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private AddressDaoImpl underTest;

    @Test
    public void testThatCreateAddressGeneratesCorrectSql(){
        Address address = TestDataUtil.createTestAddress();

        underTest.create(address);

        verify(jdbcTemplate).update(
                eq("INSERT INTO addresses (id, street, post_code, city, country) VALUES (?, ?, ?, ?, ?)"),
                eq(1L), eq("Avenida Afonso Pena, 1710"), eq("13.025-152"), eq("São Paulo"), eq("Brasil")
        );
    }
}
