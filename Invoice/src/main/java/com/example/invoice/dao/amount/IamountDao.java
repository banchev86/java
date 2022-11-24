//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.dao.amount;

import com.example.invoice.models.Amount;
import java.util.Optional;

public interface IamountDao {
    Optional<Amount> getAllAmountByCompanyId(long id);
}
