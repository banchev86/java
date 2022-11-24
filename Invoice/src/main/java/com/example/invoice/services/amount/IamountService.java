package com.example.invoice.services.amount;

import com.example.invoice.models.Amount;

public interface IamountService {
    Amount getAllAmountByCompanyId(long id);
}
