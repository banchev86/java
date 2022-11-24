package com.example.invoice.services.application;

import com.example.invoice.models.Application;

import java.util.List;

public interface IapplicationService {
    List<Application> personsByComp(long companyId);
    List<Application> searchByPerson(long individId);
    List<Application> orderBy(long companyId, String param);
    List<Application> searchBy(long companyId,String param,String val);



}
