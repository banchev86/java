package com.example.invoice.services.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class ApplicationServiceImplTest {
    @Autowired
    private  IapplicationService applicationService;
    @Test
    void personsByComp() {
        assertDoesNotThrow(()->this.applicationService.personsByComp(3L));
    }

    @Test
    void searchByPerson() {
        assertDoesNotThrow(()->this.applicationService.personsByComp(41L));
    }

    @Test
    void orderBy() {
        assertDoesNotThrow(()->this.applicationService.orderBy(3L,"dates"));
        assertDoesNotThrow(()->this.applicationService.orderBy(3L,"amount"));
        assertDoesNotThrow(()->this.applicationService.orderBy(3L,"ref"));
    }

    @Test
    void searchBy() {
        assertDoesNotThrow(()->this.applicationService.searchBy(3L,"dates","2020-07-08"));
        assertDoesNotThrow(()->this.applicationService.searchBy(3L,"amount","1234.56"));
        assertDoesNotThrow(()->this.applicationService.searchBy(3L,"ref","3234"));
    }
}