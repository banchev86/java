package com.example.invoice.services.companies;

import com.example.invoice.models.Company;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class CompaniesServiceImplTest {
    
    @Autowired
    private IcompaniesService companiesService;
    
    @Test
    void allCompanies() {
        assertDoesNotThrow(()->this.companiesService.allCompanies());
    }

    @Test
    void addCompany() {
        Company company= new Company();
        company.setName("Balkan");
        assertDoesNotThrow(()->this.companiesService.addCompany(company));
    }

    @Test
    void getCompany() {
        Company company= new Company();
        company.setName("Pepsi-cola");
        company.setCompanyId(3L);
        assertEquals(company.getCompanyId(),this.companiesService.getCompany(3L).getCompanyId());
        assertEquals(company.getName(),this.companiesService.getCompany(3L).getName());
    }

    @Test
    void deleteCompany() {
        assertDoesNotThrow(()->this.companiesService.deleteCompany(3L));
    }

    @Test
    void updateCompany() {
        Company company= new Company();
        company.setName("Pepsi-cola");
        company.setCompanyId(3L);
        assertDoesNotThrow(()->this.companiesService.addCompany(company));

    }


}