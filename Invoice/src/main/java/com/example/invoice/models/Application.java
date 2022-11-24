package com.example.invoice.models;

import java.math.BigDecimal;

public class Application {

  private  String companyName;
  private  String individName;
  private  String individType;
  private  Long   referenceRef;
  private BigDecimal amount;
  private String issueDate;




    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndividName() {
        return individName;
    }

    public void setIndividName(String individName) {
        this.individName = individName;
    }

    public String getIndividType() {
        return individType;
    }

    public void setIndividType(String individType) {
        this.individType = individType;
    }

    public long getReferenceRef() {
        return referenceRef;
    }

    public void setReferenceRef(long referenceRef) {
        this.referenceRef = referenceRef;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
}
