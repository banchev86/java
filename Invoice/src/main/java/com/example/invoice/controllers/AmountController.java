//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.controllers;

import com.example.invoice.commons.Validator;
import com.example.invoice.models.Amount;
import com.example.invoice.services.amount.IamountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmountController {
    private final IamountService amountService;
    private final Validator m;

    @Autowired
    public AmountController(IamountService amountService, Validator m) {
        this.amountService = amountService;
        this.m = m;
    }

    @GetMapping({"/api/v1/amounts/{companyId}"})
    public ResponseEntity<Amount> AmountByCompany(@PathVariable("companyId") String companyId) {
        return new ResponseEntity<>(this.amountService.getAllAmountByCompanyId(this.m.notValidCompanyId(companyId)), HttpStatus.OK);
    }
}
