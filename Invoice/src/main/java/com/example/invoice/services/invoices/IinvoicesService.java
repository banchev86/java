package com.example.invoice.services.invoices;

import com.example.invoice.models.Invoice;

import java.util.List;

public interface IinvoicesService {

    List<Invoice> allInvoices();
    void addInvoice(Invoice invoice);
    Invoice getInvoice(long id);
    void deleteInvoice(long id);
    void updateInvoice(Invoice invoice);
}
