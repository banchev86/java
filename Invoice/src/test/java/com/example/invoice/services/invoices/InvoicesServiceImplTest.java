package com.example.invoice.services.invoices;

import com.example.invoice.models.Invoice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class InvoicesServiceImplTest {
  @Autowired  
  private IinvoicesService invoicesService;
    @Test
    void allInvoices() {
        assertDoesNotThrow(()->this.invoicesService.allInvoices());
    }

    @Test
    void addInvoice() {
        Invoice invoice = new Invoice();
        invoice.setDate("2020-01-01 12:30:00");
        invoice.setAmount(new BigDecimal("234.56"));
        invoice.setIndividId(41L);
        assertDoesNotThrow(()->this.invoicesService.addInvoice(invoice));
    }

    @Test
    void getInvoice() {

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(126L);
        invoice.setIndividId(39L);
        invoice.setAmount(new BigDecimal("3456.78"));
        invoice.setDate("2014-08-30 00:00:00");
        assertEquals(invoice.getInvoiceId(),this.invoicesService.getInvoice(126L).getInvoiceId());
        assertEquals(invoice.getIndividId(),this.invoicesService.getInvoice(126L).getIndividId());
        assertEquals(invoice.getAmount(),this.invoicesService.getInvoice(126L).getAmount());
        assertEquals(invoice.getDate(),this.invoicesService.getInvoice(126L).getDate());
    }

    @Test
    void deleteInvoice() {
        Long id=1L;
        assertDoesNotThrow(()->this.invoicesService.deleteInvoice(id));
    }

    @Test
    void updateInvoice() {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1L);
        invoice.setIndividId(41L);
        invoice.setAmount(new BigDecimal("1234.56"));
        invoice.setDate("2020-01-11 12:30:00");
        assertDoesNotThrow(()->this.invoicesService.updateInvoice(invoice));
    }
}