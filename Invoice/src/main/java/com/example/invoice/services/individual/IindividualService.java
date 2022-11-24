package com.example.invoice.services.individual;

import com.example.invoice.models.Individual;

import java.util.List;

public interface IindividualService {
    List<Individual> allIndividuals();


    void addIndividual(Individual individual);

    Individual getIndividual(long id);
    void deleteIndividual(long id);
    void updateIndividual(Individual individual);
}
