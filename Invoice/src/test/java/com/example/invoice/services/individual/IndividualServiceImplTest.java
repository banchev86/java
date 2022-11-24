package com.example.invoice.services.individual;

import com.example.invoice.models.Individual;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class IndividualServiceImplTest {
    
    @Autowired
     private IindividualService individualService;
    @Test
    void allIndividuals() {
        assertDoesNotThrow(()->this.individualService.allIndividuals());
    }

    @Test
    void addIndividual() {
        Individual individual=new Individual();
        individual.setCompanyId(3L);
        individual.setName("Ivan Ivanov");
        individual.setType("legal");
        assertDoesNotThrow(()->this.individualService.addIndividual(individual));
    }

    @Test
    void getIndividual() {
        Individual individual=new Individual();
        individual.setCompanyId(3L);
        individual.setName("Georgi Georgiev");
        individual.setType("legal");
        individual.setIndividId(41L);
        assertEquals(individual.getCompanyId(),this.individualService.getIndividual(41L).getCompanyId());
        assertEquals(individual.getName(),this.individualService.getIndividual(41L).getName());
        assertEquals(individual.getType(),this.individualService.getIndividual(41L).getType());
        assertEquals(individual.getIndividId(),this.individualService.getIndividual(41L).getIndividId());
    }

    @Test
    void deleteIndividual() {
        assertDoesNotThrow(()->this.individualService.deleteIndividual(41L));
    }

    @Test
    void updateIndividual() {
        Individual individual=new Individual();
        individual.setCompanyId(3L);
        individual.setName("Ivan Banchev");
        individual.setType("legal");
        individual.setIndividId(41L);
        assertDoesNotThrow(()->this.individualService.updateIndividual(individual));
    }
}