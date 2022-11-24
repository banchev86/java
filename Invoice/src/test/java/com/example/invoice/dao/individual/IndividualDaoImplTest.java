package com.example.invoice.dao.individual;

import com.example.invoice.models.Individual;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class IndividualDaoImplTest {
    @Autowired
    private IindividualDoa individualDoa;

    @Test
    void allIndividuals() {
        assertDoesNotThrow(()->this.individualDoa.allIndividuals());
    }

    @Test
    void addIndividual() {
        Individual individual=new Individual();
        individual.setCompanyId(3L);
        individual.setName("Ivan Ivanov");
        individual.setType("legal");
        assertDoesNotThrow(()->this.individualDoa.addIndividual(individual));
    }

    @Test
    void getIndividual() {
        Individual individual=new Individual();
        individual.setCompanyId(3L);
        individual.setName("Georgi Georgiev");
        individual.setType("legal");
        individual.setIndividId(41L);
        assertEquals(individual.getCompanyId(),this.individualDoa.getIndividual(41L).get().getCompanyId());
        assertEquals(individual.getName(),this.individualDoa.getIndividual(41L).get().getName());
        assertEquals(individual.getType(),this.individualDoa.getIndividual(41L).get().getType());
        assertEquals(individual.getIndividId(),this.individualDoa.getIndividual(41L).get().getIndividId());
    }

    @Test
    void deleteIndividual() {
        assertDoesNotThrow(()->this.individualDoa.deleteIndividual(41L));
    }

    @Test
    void updateIndividual() {
        Individual individual=new Individual();
        individual.setCompanyId(3L);
        individual.setName("Ivan Banchev");
        individual.setType("legal");
        individual.setIndividId(41L);
        assertDoesNotThrow(()->this.individualDoa.updateIndividual(individual));
    }

    @Test
    void isValidIndividId() {
        assertEquals(true,this.individualDoa.isValidIndividId(41L));
    }
}