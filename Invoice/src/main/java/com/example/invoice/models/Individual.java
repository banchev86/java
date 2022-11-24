package com.example.invoice.models;

public class Individual {
    private Long individId;
    private String name;
    private String type;
    private Long companyId;

    public Long getIndividId() {
        return individId;
    }

    public void setIndividId(Long individId) {
        this.individId = individId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }
}
