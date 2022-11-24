//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.controllers;

import com.example.invoice.commons.Validator;
import com.example.invoice.models.Company;
import com.example.invoice.services.companies.IcompaniesService;
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
public class CompaniesController {
    private final IcompaniesService companiesService;
    private final Validator m;

    @Autowired
    public CompaniesController(IcompaniesService companiesService, Validator m) {
        this.companiesService = companiesService;
        this.m = m;
    }

    @RequestMapping({"/api/v1/companies/"})
    @PostMapping(
            consumes = {"application/json"}
    )
    public ResponseEntity<Void> createCompany(@RequestBody Company company) {
        this.companiesService.addCompany(this.m.isValid(company));
        return ResponseEntity.ok().build();
    }

    @RequestMapping({"/api/v1/companies/{id}"})
    @PutMapping(
            consumes = {"application/json"}
    )
    public ResponseEntity<Void> updateCompany(@PathVariable("id") String id, @RequestBody Company company) {
        this.companiesService.updateCompany(this.m.isValid(id, company));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping({"/api/v1/companies/{id}"})
    public ResponseEntity<Void> deleteCompany(@PathVariable("id") String id) {
        this.companiesService.deleteCompany(this.m.notValidCompanyId(id));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping({"/api/v1/companies/{id}"})
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.companiesService.getCompany(this.m.notValidCompanyId(id)), HttpStatus.OK);
    }

    @GetMapping({"/api/v1/companies/all"})
    public ResponseEntity<List<Company>> getAllCompanies() {
        return new ResponseEntity<>(this.companiesService.allCompanies(), HttpStatus.OK);
    }
}
