//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.dao.companies;

import com.example.invoice.models.Company;
import java.util.List;
import java.util.Optional;

public interface IcompaniesDoa {
    List<Company> allCompanies();

    void addCompany(Company company);

    Optional<Company> getCompany(long id);

    void deleteCompany(long id);

    void updateCompany(Company company);

    boolean isValidCompanyId(long id);


}
