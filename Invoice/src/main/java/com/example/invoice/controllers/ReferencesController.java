//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.controllers;

import com.example.invoice.commons.Validator;
import com.example.invoice.dto.ReferenceRequestUpdate;
import com.example.invoice.models.Reference;
import com.example.invoice.services.references.IreferencesService;
import java.util.List;
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
public class ReferencesController {
    private final IreferencesService referencesService;
    private final Validator m;

    public ReferencesController(IreferencesService referencesService, Validator m) {
        this.referencesService = referencesService;
        this.m = m;
    }

    @RequestMapping({"/api/v1/referencies/"})
    @PostMapping(
            consumes = {"application/json"}
    )
    public ResponseEntity<Void> createReference(@RequestBody Reference reference) {
        this.referencesService.addReference(this.m.isValid(reference));
        return ResponseEntity.ok().build();
    }

    @RequestMapping({"/api/v1/referencies/{id}"})
    @PutMapping(
            consumes = {"application/json"}
    )
    public ResponseEntity<Void> updateReference(@PathVariable("id") String id, @RequestBody ReferenceRequestUpdate reference) {
        this.referencesService.updateReference(this.m.isValid(id, reference));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping({"/api/v1/referencies/{id}"})
    public ResponseEntity<Void> deleteReference(@PathVariable("id") String id) {
        this.referencesService.deleteReference(this.m.notValidRefId(id));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping({"/api/v1/referencies/{id}"})
    public ResponseEntity<Reference> ReferenceById(@PathVariable("id") String id) {
        return new ResponseEntity<>(this.referencesService.getReference(this.m.notValidRefId(id)), HttpStatus.OK);
    }

    @GetMapping({"/api/v1/referencies/all"})
    public ResponseEntity<List<Reference>> getAllCompanies() {
        return new ResponseEntity<>(this.referencesService.allReferences(), HttpStatus.OK);
    }
}
