package com.example.invoice.services.references;

import com.example.invoice.models.Reference;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class ReferencesServiceImplTest { 
    @Autowired
    private IreferencesService referencesService;


    @Test
    void allReferences() {
        assertDoesNotThrow(()->this.referencesService.allReferences());
    }

    @Test
    void addReference() {
        Reference reference = new Reference();
        reference.setRef(1L);
        reference.setIndividId(41L);
        assertDoesNotThrow(()->this.referencesService.addReference(reference));

    }

    @Test
    void getReference() {
        Optional<Reference> reference= Optional.of(new Reference());
        reference.get().setRef(3051L);
        reference.get().setIndividId(39L);

        assertEquals(reference.get().getIndividId(),this.referencesService.getReference(3051L).getIndividId());
        assertEquals(reference.get().getRef(),this.referencesService.getReference(3051L).getRef());
    }

    @Test
    void deleteReference() {
        Long id=3234L;
        assertDoesNotThrow(()->this.referencesService.deleteReference(id));
    }

    @Test
    void updateReference() {
        Reference reference = new Reference();
        reference.setRef(3234L);
        reference.setIndividId(41L);
        assertDoesNotThrow(()->this.referencesService.updateReference(reference));
    }
}