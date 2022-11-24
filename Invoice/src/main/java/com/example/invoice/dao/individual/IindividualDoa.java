//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.invoice.dao.individual;

import com.example.invoice.models.Individual;
import java.util.List;
import java.util.Optional;

public interface IindividualDoa {
    List<Individual> allIndividuals();

    void addIndividual(Individual individual);

    Optional<Individual> getIndividual(long id);

    void deleteIndividual(long id);

    void updateIndividual(Individual individual);

    boolean isValidIndividId(long id);

}
