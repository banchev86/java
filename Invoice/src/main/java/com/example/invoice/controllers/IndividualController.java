//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.controllers;

import com.example.invoice.commons.Validator;
import com.example.invoice.models.Individual;
import com.example.invoice.services.individual.IindividualService;
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
public class IndividualController {
    private final IindividualService individualService;
    private final Validator m;

    @Autowired
    public IndividualController(IindividualService individualService, Validator m) {
        this.individualService = individualService;
        this.m = m;
    }

    @RequestMapping({"/api/v1/individuals/"})
    @PostMapping(
            consumes = {"application/json"}
    )
    public ResponseEntity<Void> createIndividual(@RequestBody Individual individual) {
        this.individualService.addIndividual(this.m.isValid(individual));
        return ResponseEntity.ok().build();
    }

    @RequestMapping({"/api/v1/individuals/{id}"})
    @PutMapping(
            consumes = {"application/json"}
    )
    public ResponseEntity<Void> updateIndividual(@PathVariable("id") String id, @RequestBody Individual individual) {

        this.individualService.updateIndividual(this.m.isValid(id, individual));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping({"/api/v1/individuals/{id}"})
    public ResponseEntity<Void> deleteIndividual(@PathVariable("id") String id) {
        this.individualService.deleteIndividual(this.m.notValidIndividId(id));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping({"/api/v1/individuals/{id}"})
    public ResponseEntity<Individual> getIndividualById(@PathVariable("id") String id) {

        return new ResponseEntity<>(this.individualService.getIndividual(this.m.notValidIndividId(id)), HttpStatus.OK);
    }

    @GetMapping({"/api/v1/individuals/all"})
    public ResponseEntity<List<Individual>> getAllIndividuals() {
        return new ResponseEntity<>(this.individualService.allIndividuals(), HttpStatus.OK);
    }
}
