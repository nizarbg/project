package com.location.service;

import com.location.model.Entretient;

import java.util.List;

public interface EntretientService {
    public List listAllEntretient();

    public void addEntretient(Entretient entr);

    public void updateEntretient(Entretient entr);

    public void delete(Entretient entr);

    public Entretient findEntretientById(Entretient entr);

}
