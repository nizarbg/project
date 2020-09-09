package com.location.dao;

import com.location.model.Entretient;

import java.util.List;

public interface EntretientDao {
    public List listAllEntretient();

    public void addEntretient(Entretient entr);

    public void updateEntretient(Entretient entr);

    public void delete(Entretient entr);

    public Entretient findEntretientById(Entretient entr);

}
