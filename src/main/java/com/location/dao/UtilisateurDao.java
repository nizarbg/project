package com.location.dao;

import java.util.List;

import com.location.model.Utilisateur;

public interface UtilisateurDao {

    public List listAllUtilisateur();

    public void addUtilisateur(Utilisateur u);

    public void updateUtilisateur(Utilisateur u);

    public void delete(Utilisateur u);

    public Utilisateur findUtilisateurById(Utilisateur u);

}