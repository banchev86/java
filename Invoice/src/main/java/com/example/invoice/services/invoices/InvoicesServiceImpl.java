package com.example.invoice.services.invoices;

import com.example.invoice.dao.invoices.IinvoicesDoa;
import com.example.invoice.exceptions.NonExistExp;
import com.example.invoice.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoicesServiceImpl implements IinvoicesService {
    private final IinvoicesDoa invoicesDoa;


    @Autowired
    public InvoicesServiceImpl(IinvoicesDoa invoicesDoa) {
        this.invoicesDoa = invoicesDoa;
    }

    @Override
    public List<Invoice> allInvoices() {
        return this.invoicesDoa.allInvoices();
    }

    @Override
    public void addInvoice(Invoice invoice) {

          this.invoicesDoa.addInvoice(invoice);
    }

    @Override
    public Invoice getInvoice(long id) {

        return this.invoicesDoa.getInvoice(id).
                orElseThrow(()->new NonExistExp("Invoice does mot exist"));
    }

    @Override
    public void deleteInvoice(long id) {

         this.invoicesDoa.deleteInvoice(id);
    }

    @Override
    public void updateInvoice(Invoice invoice) {

         this.invoicesDoa.updateInvoice(invoice);
    }


}
