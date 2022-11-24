package com.example.invoice.models;

import java.math.BigDecimal;

public class Invoice {

    private Long invoiceId;
    private Long individId;
    private BigDecimal amount;
    private String date;

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getIndividId() {
        return individId;
    }

    public void setIndividId(Long individId) {
        this.individId = individId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
