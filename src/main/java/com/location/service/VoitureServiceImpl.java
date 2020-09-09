package com.location.service;

import java.util.List;


import com.location.dao.VoitureDao;
import com.location.model.Voiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.dao.ModeleDao;
import com.location.model.Modele;

@Service
public class VoitureServiceImpl implements VoitureService {

    VoitureDao voitureDao;

    @Autowired
    public void setVoitureDao(VoitureDao voitureDao) {
        this.voitureDao = voitureDao;
    }

    public List listAllVoiture() {
        return voitureDao.listAllVoiture();
    }

    public void addVoiture(Voiture voiture) {
        voitureDao.addVoiture(voiture);
    }

    public void updateVoiture(Voiture voiture) {
        voitureDao.updateVoiture(voiture);
    }

    public void delete(Voiture voiture) {
        voitureDao.delete(voiture);
    }

    public  Voiture findVoitureById(Voiture voiture) {
        return voitureDao.findVoitureById(voiture);
    }

}