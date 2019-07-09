package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Invoice;

import java.util.List;

public interface InvoiceDao {

    Invoice addInvoice(Invoice invoice);

    Invoice getInvoice(int id);

    List<Invoice> getAllInvoices();

    Invoice updateInvoice(Invoice invoice);

    void deleteInvoice(int id);

    List<Invoice> findInvoiceByCustomer(int customerId);

}
