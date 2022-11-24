package com.example.invoice.services.amount;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class AmountServiceImplTest {
 @Autowired
  private IamountService amountService;
    @Test
    void getAllAmountByCompanyId() {
            assertDoesNotThrow(()->this.amountService.getAllAmountByCompanyId(3L));

    }
}