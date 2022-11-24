package com.example.invoice.dao.invoices;

import com.example.invoice.models.Invoice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class InvoicesDoaImplTest {
    @Autowired
    private IinvoicesDoa invoicesDoa;
    @Test
    void allInvoices() {
        assertDoesNotThrow(()->this.invoicesDoa.allInvoices());
    }

    @Test
    void addInvoice() {
        Invoice invoice = new Invoice();
        invoice.setDate("2020-01-01 12:30:00");
        invoice.setAmount(new BigDecimal("234.56"));
        invoice.setIndividId(41L);
        assertDoesNotThrow(()->this.invoicesDoa.addInvoice(invoice));
    }

    @Test
    void getInvoice() {

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(126L);
        invoice.setIndividId(39L);
        invoice.setAmount(new BigDecimal("3456.78"));
        invoice.setDate("2014-08-30 00:00:00");
        assertEquals(invoice.getInvoiceId(),this.invoicesDoa.getInvoice(126L).get().getInvoiceId());
        assertEquals(invoice.getIndividId(),this.invoicesDoa.getInvoice(126L).get().getIndividId());
        assertEquals(invoice.getAmount(),this.invoicesDoa.getInvoice(126L).get().getAmount());
        assertEquals(invoice.getDate(),this.invoicesDoa.getInvoice(126L).get().getDate());
    }

    @Test
    void deleteInvoice() {
        Long id=1L;
        assertDoesNotThrow(()->this.invoicesDoa.deleteInvoice(id));
    }

    @Test
    void updateInvoice() {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1L);
        invoice.setIndividId(41L);
        invoice.setAmount(new BigDecimal("1234.56"));
        invoice.setDate("2020-01-11 12:30:00");
        assertDoesNotThrow(()->this.invoicesDoa.updateInvoice(invoice));
    }

    @Test
    void isValidInvoiceId() {
        assertEquals(true,this.invoicesDoa.isValidInvoiceId(126L));
    }
}