package com.example.invoice.dao.companies;

import com.example.invoice.models.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional

class CompaniesDaoImplTest {

    @Autowired
    private IcompaniesDoa companiesDoa;

    @Test
    void allCompanies() {
        assertDoesNotThrow(()->this.companiesDoa.allCompanies());
    }

    @Test
    void addCompany() {
        Company company= new Company();
        company.setName("Balkan");
        assertDoesNotThrow(()->this.companiesDoa.addCompany(company));
    }

    @Test
    void getCompany() {
        Company company= new Company();
        company.setName("Pepsi-cola");
        company.setCompanyId(3L);
        assertEquals(company.getCompanyId(),this.companiesDoa.getCompany(3L).get().getCompanyId());
        assertEquals(company.getName(),this.companiesDoa.getCompany(3L).get().getName());


    }

    @Test
    void deleteCompany() {
        assertDoesNotThrow(()->this.companiesDoa.deleteCompany(3L));
    }

    @Test
    void updateCompany() {
        Company company= new Company();
        company.setName("Pepsi-cola");
        company.setCompanyId(3L);
        assertDoesNotThrow(()->this.companiesDoa.addCompany(company));

    }

    @Test
    void isValidCompanyId() {
        assertEquals(true,this.companiesDoa.isValidCompanyId(3L));
    }


}