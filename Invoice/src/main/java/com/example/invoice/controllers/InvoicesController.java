//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.controllers;

import com.example.invoice.commons.Validator;
import com.example.invoice.models.Invoice;
import com.example.invoice.services.invoices.IinvoicesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoicesController {
    private final IinvoicesService invoicesService;
    private final Validator m;

    @Autowired
    public InvoicesController(IinvoicesService invoicesService, Validator m) {
        this.invoicesService = invoicesService;
        this.m = m;
    }

    @RequestMapping({"/api/v1/invoices/"})
    @PostMapping(
            consumes = {"application/json"}
    )
    public ResponseEntity<Void> createInvoice(@RequestBody Invoice invoice) {
        this.invoicesService.addInvoice(this.m.isValid(invoice));
        return ResponseEntity.ok().build();
    }

    @RequestMapping({"/api/v1/invoices/{id}"})
    @PutMapping(
            consumes = {"application/json"}
    )
    public ResponseEntity<Void> updateInvoice(@PathVariable("id") String id, @RequestBody Invoice invoice) {
        this.invoicesService.updateInvoice(this.m.isValid(id, invoice));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping({"/api/v1/invoices/{id}"})
    public ResponseEntity<Void> deleteInvoice(@PathVariable("id") String id) {
        this.invoicesService.deleteInvoice(this.m.notValidInvoiceId(id));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping({"/api/v1/invoices/{id}"})
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.invoicesService.getInvoice(this.m.notValidInvoiceId(id)), HttpStatus.OK);
    }

    @GetMapping({"/api/v1/invoices/all"})
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return new ResponseEntity<>(this.invoicesService.allInvoices(), HttpStatus.OK);
    }
}
