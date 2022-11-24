package com.example.invoice.services.companies;

import com.example.invoice.models.Company;

import java.util.List;
import java.util.Optional;

public interface IcompaniesService {
    List<Company> allCompanies();


    void addCompany(Company company);

    Company getCompany(long id);
    void deleteCompany(long id);
    void updateCompany(Company company);
}
