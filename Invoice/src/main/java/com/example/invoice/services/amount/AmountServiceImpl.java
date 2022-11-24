package com.example.invoice.services.amount;

import com.example.invoice.dao.amount.IamountDao;
import com.example.invoice.exceptions.NonExistExp;
import com.example.invoice.models.Amount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmountServiceImpl implements IamountService{

    private final IamountDao amountDao;


    @Autowired
    public AmountServiceImpl(IamountDao amountDao) {
        this.amountDao = amountDao;

    }

    @Override
    public Amount getAllAmountByCompanyId(long id) {


        return this.amountDao.getAllAmountByCompanyId(id).
                orElseThrow(()->new NonExistExp("Amount does mot exist"));
    }



}
