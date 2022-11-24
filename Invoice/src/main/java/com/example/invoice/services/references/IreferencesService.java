package com.example.invoice.services.references;

import com.example.invoice.models.Reference;

import java.util.List;

public interface IreferencesService {
    List<Reference> allReferences();
    void addReference(Reference reference);
    Reference getReference(long id);
    void updateReference(Reference reference);
    void deleteReference(long id);

}
