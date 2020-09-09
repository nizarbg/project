package com.location.service;

import com.location.model.Voiture;

import java.util.List;

public interface VoitureService {
    public List listAllVoiture();

    public void addVoiture(Voiture v);

    public void updateVoiture(Voiture v);

    public void delete(Voiture v);

    public Voiture findVoitureById(Voiture v);
}
