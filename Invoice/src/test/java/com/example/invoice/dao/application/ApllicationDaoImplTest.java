package com.example.invoice.dao.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class ApllicationDaoImplTest {

     @Autowired
     private IapplicationDao applicationDao;

    @Test
    void personsByComp() {
        assertDoesNotThrow(()->this.applicationDao.personsByComp(3L));
    }

    @Test
    void searchByPerson() {
        assertDoesNotThrow(()->this.applicationDao.personsByComp(41L));
    }


    @Test
    void orderBy() {
        assertDoesNotThrow(()->this.applicationDao.orderBy(3L,"dates"));
        assertDoesNotThrow(()->this.applicationDao.orderBy(3L,"amount"));
        assertDoesNotThrow(()->this.applicationDao.orderBy(3L,"ref"));
        assertDoesNotThrow(()->this.applicationDao.orderBy(3L,"name"));
        assertDoesNotThrow(()->this.applicationDao.orderBy(3L,"type"));
    }

    @Test
    void searchBy() {

        assertDoesNotThrow(()->this.applicationDao.searchBy(3L,"date","TO_DATE('2020-02-11','YYYY-MM-DD')"));
        assertDoesNotThrow(()->this.applicationDao.searchBy(3L,"amount","1234.56"));
        assertDoesNotThrow(()->this.applicationDao.searchBy(3L,"ref","3234"));
        assertDoesNotThrow(()->this.applicationDao.searchBy(3L,"type","'legal'"));

    }
}