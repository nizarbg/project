package com.location.service;

import com.location.model.Modele;


import java.util.List;

public interface ModeleService {
    public List listAllModele();

    public void addModele(Modele mdl);

    public void updateModele(Modele mdl);

    public void delete(Modele mdl);

    public Modele findModeleById(Modele mdl);
}