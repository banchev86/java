package com.example.invoice.services.individual;

import com.example.invoice.dao.individual.IindividualDoa;
import com.example.invoice.exceptions.NonExistExp;
import com.example.invoice.models.Individual;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualServiceImpl implements IindividualService {
    private final IindividualDoa individualDoa;

    public IndividualServiceImpl(IindividualDoa individualDoa) {
        this.individualDoa = individualDoa;
    }

    @Override
    public List<Individual> allIndividuals() {
        return this.individualDoa.allIndividuals();
    }

    @Override
    public void addIndividual(Individual individual) {

        this.individualDoa.addIndividual(individual);
    }

    @Override
    public Individual getIndividual(long id) {

        return this.individualDoa.getIndividual(id).
                orElseThrow(()->new NonExistExp("Individual does mot exist"));
    }

    @Override
    public void deleteIndividual(long id) {

        this.individualDoa.deleteIndividual(id);
    }

    @Override
    public void updateIndividual(Individual individual) {

         this.individualDoa.updateIndividual(individual);
    }



}
