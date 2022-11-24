package com.example.invoice.services.companies;

import com.example.invoice.dao.companies.IcompaniesDoa;
import com.example.invoice.exceptions.NonExistExp;
import com.example.invoice.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompaniesServiceImpl implements IcompaniesService {
    private final IcompaniesDoa companiesDoa;

    @Autowired
    public CompaniesServiceImpl(IcompaniesDoa companiesDoa) {
        this.companiesDoa = companiesDoa;
    }

    @Override
    public List<Company> allCompanies() {
        return this.companiesDoa.allCompanies();
    }

    @Override
    public void addCompany(Company company) {

           this.companiesDoa.addCompany(company);
    }

    @Override
    public Company getCompany(long id) {

        return this.companiesDoa.getCompany(id).
                orElseThrow(()->new NonExistExp("Company does mot exist"));
    }

    @Override
    public void deleteCompany(long id) {

       this.companiesDoa.deleteCompany(id);
    }

    @Override
    public void updateCompany(Company company) {

         this.companiesDoa.updateCompany(company);
    }


}
