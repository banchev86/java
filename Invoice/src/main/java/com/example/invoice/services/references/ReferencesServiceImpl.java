package com.example.invoice.services.references;

import com.example.invoice.dao.references.IreferencesDoa;
import com.example.invoice.exceptions.NonExistExp;
import com.example.invoice.models.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferencesServiceImpl implements IreferencesService {
    private final IreferencesDoa referencesDoa;




    @Autowired
    public ReferencesServiceImpl(IreferencesDoa referencesDoa) {
        this.referencesDoa = referencesDoa;
    }

    @Override
    public List<Reference> allReferences() {

        return  this.referencesDoa.allReferences();
    }

    @Override
    public void addReference(Reference reference) {

        this.referencesDoa.addReference(reference);
    }

    @Override
    public Reference getReference(long id) {

        return this.referencesDoa.getReference(id).
                orElseThrow(()->new NonExistExp("Reference does mot exist"));
    }

    @Override
    public void updateReference(Reference reference) {
        this.referencesDoa.updateReference(reference);
    }

    @Override
    public void deleteReference(long id) {
        this.referencesDoa.deleteReference(id);
    }


}
