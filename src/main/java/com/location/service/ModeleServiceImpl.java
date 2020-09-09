package com.location.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.dao.ModeleDao;
import com.location.model.Modele;

@Service
public class ModeleServiceImpl implements ModeleService {

    ModeleDao modeleDao;

    @Autowired
    public void setModeleDao(ModeleDao modeleDao) {
        this.modeleDao = modeleDao;
    }

    public List listAllModele() {
        return modeleDao.listAllModele();
    }

    public void addModele(Modele modele) {
        modeleDao.addModele(modele);
    }

    public void updateModele(Modele modele) {
        modeleDao.updateModele(modele);
    }

    public void delete(Modele modele) {
        modeleDao.delete(modele);
    }

    public Modele findModeleById(Modele modele) {
        return modeleDao.findModeleById(modele);
    }

}