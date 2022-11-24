//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.dao.invoices;

import com.example.invoice.models.Invoice;
import java.util.List;
import java.util.Optional;

public interface IinvoicesDoa {
    List<Invoice> allInvoices();

    void addInvoice(Invoice invoice);

    Optional<Invoice> getInvoice(long id);

    void deleteInvoice(long id);

    void updateInvoice(Invoice invoice);

    boolean isValidInvoiceId(long id);
}
