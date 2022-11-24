package com.example.invoice.dao.references;

import com.example.invoice.dto.ReferenceRequestUpdate;
import com.example.invoice.models.Reference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class ReferencesDaoImplTest {

    @Autowired
   private IreferencesDoa referencesDoa;
    @BeforeEach
    void setUp() {
    }

    @Test
    void allReferences() {
        assertDoesNotThrow(()->this.referencesDoa.allReferences());
    }

    @Test
    void addReference() {
        Reference reference = new Reference();
        reference.setRef(1L);
        reference.setIndividId(41L);
        assertDoesNotThrow(()->this.referencesDoa.addReference(reference));

    }

    @Test
    void getReference() {
      Optional<Reference> reference= Optional.of(new Reference());
      reference.get().setRef(3051L);
      reference.get().setIndividId(39L);

      assertEquals(reference.get().getIndividId(),this.referencesDoa.getReference(3051).get().getIndividId());
      assertEquals(reference.get().getRef(),this.referencesDoa.getReference(3051).get().getRef());
    }
    @Test
    void getReferenceThrow() {
    assertEquals(Optional.empty(),this.referencesDoa.getReference(0L));

    }
    @Test
    void deleteReference() {
        Long id=3051L;
        assertDoesNotThrow(()->this.referencesDoa.deleteReference(id));
    }

    @Test
    void updateReference() {
        Reference reference = new Reference();
        reference.setRef(3234L);
        reference.setIndividId(41L);
        assertDoesNotThrow(()->this.referencesDoa.updateReference(reference));
    }

    @Test
    void isValidRefId() {
        assertEquals(true,this.referencesDoa.isValidRefId(3051L));
    }


}