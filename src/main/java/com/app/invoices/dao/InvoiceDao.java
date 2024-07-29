package com.app.invoices.dao;

import com.app.invoices.domain.Invoice;

public interface InvoiceDao {

    void create(Invoice invoice);
}
