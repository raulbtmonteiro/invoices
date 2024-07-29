package com.app.invoices.dao.impl;

import com.app.invoices.TestDataUtil;
import com.app.invoices.domain.Invoice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class InvoiceDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private InvoiceDaoImpl underTest;

    @Test
    public void testThatCreateInvoiceGeneratesCorrectSql(){
        Invoice invoice = TestDataUtil.createInvoiceTest();

        underTest.create(invoice);

        verify(jdbcTemplate).update(
                eq("INSERT INTO invoices (id, code, status, description, created_at, client_name, client_email, client_address_id, sender_address_id, payment_terms, payment_due) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"),
                eq(1L),
                eq("XRT03"),
                eq("paid"),
                eq("Test invoice"),
                eq("teste"),
                eq("John Smith"),
                eq("john_smith@test.com"),
                eq(1L),
                eq(2L),
                eq(1),
                eq("teste")
        );
    }
}
