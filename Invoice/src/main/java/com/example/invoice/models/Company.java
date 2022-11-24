package com.example.invoice.models;

import java.util.Objects;

public class Company {
    private Long companyId;
    private String name;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company company = (Company) o;
        return getCompanyId().equals(company.getCompanyId()) && getName().equals(company.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompanyId(), getName());
    }
}
