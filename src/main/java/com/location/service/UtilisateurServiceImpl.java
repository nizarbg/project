package com.location.service;

import java.util.List;


import com.location.dao.UtilisateurDao;
import com.location.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    UtilisateurDao utilisateurDao;

    @Autowired
    public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    public List listAllUtilisateur() {
        return utilisateurDao.listAllUtilisateur();
    }

    public void addUtilisateur(Utilisateur utilisateur) {
        utilisateurDao.addUtilisateur(utilisateur);
    }

    public void updateUtilisateur(Utilisateur utilisateur) {
        utilisateurDao.updateUtilisateur(utilisateur);
    }

    public void delete(Utilisateur utilisateur) {
        utilisateurDao.delete(utilisateur);
    }

    public Utilisateur findUtilisateurById(Utilisateur utilisateur) {
        return utilisateurDao.findUtilisateurById(utilisateur);
    }

}