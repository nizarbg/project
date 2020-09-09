package com.location.dao;

import com.location.model.Contrat;

import java.util.List;

public interface ContratDao {
    public List listAllContrat();

    public void addContrat(Contrat cont);

    public void updateContrat(Contrat cont);

    public void delete(Contrat cont);

    public Contrat findContratById(Contrat cont);
}
