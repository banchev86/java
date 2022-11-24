//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.dao.application;

import com.example.invoice.models.Application;
import java.util.List;

public interface IapplicationDao {
    List<Application> personsByComp(long companyId);

    List<Application> searchByPerson(long individId);

    List<Application> orderBy(long companyId, String param);

    List<Application> searchBy(long companyId, String param, String val);
}
