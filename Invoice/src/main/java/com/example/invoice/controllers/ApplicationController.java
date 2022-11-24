//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.controllers;

import com.example.invoice.commons.Validator;
import com.example.invoice.models.Application;
import com.example.invoice.services.application.IapplicationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {
    private final IapplicationService applicationService;
    private final Validator m;

    @Autowired
    public ApplicationController(IapplicationService applicationService, Validator m) {
        this.applicationService = applicationService;
        this.m = m;
    }

    @GetMapping({"/api/v1/applications/{companyId}"})
    public ResponseEntity<List<Application>> personsByComp(@PathVariable("companyId") String companyId) {

        return new ResponseEntity<>(this.applicationService.personsByComp(this.m.notValidCompanyId(companyId)), HttpStatus.OK);
    }

    @GetMapping({"/api/v1/applications/person/{individId}"})
    public ResponseEntity<List<Application>> searchByPerson(@PathVariable("individId") String individId) {

        return new ResponseEntity<>(this.applicationService.searchByPerson(this.m.notValidIndividId(individId)), HttpStatus.OK);
    }

    @GetMapping({"/api/v1/applications/{companyId}/sort/"})
    public ResponseEntity<List<Application>> orderBy(@PathVariable("companyId") String companyId, @RequestParam("param") String param) {

        return new ResponseEntity<>(this.applicationService.orderBy(this.m.notValidCompanyId(companyId), this.m.notValidParam(param)), HttpStatus.OK);
    }

    @GetMapping({"/api/v1/applications/{companyId}/search/"})
    public ResponseEntity<List<Application>> searchBy(@PathVariable("companyId") String companyId, @RequestParam("param") String param, @RequestParam("value") String val) {

        return new ResponseEntity<>(this.applicationService.searchBy(this.m.notValidCompanyId(companyId), param, this.m.val(param, val)), HttpStatus.OK);
    }
}
