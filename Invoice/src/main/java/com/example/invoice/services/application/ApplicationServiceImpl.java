package com.example.invoice.services.application;

import com.example.invoice.dao.application.IapplicationDao;
import com.example.invoice.models.Application;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements IapplicationService {

    private final IapplicationDao applicationDao;



    public ApplicationServiceImpl(IapplicationDao applicationDao) {

        this.applicationDao = applicationDao;

    }

    @Override
    public List<Application> personsByComp(long companyId) {

        return this.applicationDao.personsByComp(companyId);
    }

    @Override
    public List<Application> searchByPerson(long individId) {


        return this.applicationDao.searchByPerson(individId);
    }

    @Override
    public List<Application> orderBy(long companyId, String param) {

        return this.applicationDao.orderBy(companyId,param);
    }

    @Override
    public List<Application> searchBy(long companyId, String param, String val) {
        return this.applicationDao.searchBy(companyId,param,val);
    }


}
