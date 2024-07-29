package com.app.invoices.dao.impl;

import com.app.invoices.dao.InvoiceDao;
import com.app.invoices.domain.Invoice;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


public class InvoiceDaoImpl implements InvoiceDao {

    private final JdbcTemplate jdbcTemplate;

    public InvoiceDaoImpl(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Invoice invoice) {
        jdbcTemplate.update(
                "INSERT INTO invoices (id, code, status, description, created_at, client_name, client_email, client_address_id, sender_address_id, payment_terms, payment_due) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                invoice.getId(),
                invoice.getCode(),
                invoice.getStatus(),
                invoice.getDescription(),
                invoice.getCreatedAt(),
                invoice.getClientName(),
                invoice.getClientEmail(),
                invoice.getClientAddressId(),
                invoice.getSenderAddressId(),
                invoice.getPaymentTerms(),
                invoice.getPaymentDue()
        );
    }
}
