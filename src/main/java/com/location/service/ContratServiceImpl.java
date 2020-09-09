package com.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.dao.ContratDao;
import com.location.model.Contrat;

@Service
public class ContratServiceImpl implements ContratService {

    ContratDao contratDao;

    @Autowired
    public void setContratDao(ContratDao contratDao) {
        this.contratDao = contratDao;
    }

    public List listAllContrat() {
        return contratDao.listAllContrat();
    }

    public void addContrat(Contrat contrat) {
        contratDao.addContrat(contrat);
    }

    public void updateContrat(Contrat contrat) {
        contratDao.updateContrat(contrat);
    }

    public void delete(Contrat contrat) {
        contratDao.delete(contrat);
    }

    public Contrat findContratById(Contrat contrat) {
        return contratDao.findContratById(contrat);
    }

}