package com.location.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.dao.EntretientDao;
import com.location.model.Entretient;

@Service
public class EntretientServiceImpl implements EntretientService {

    EntretientDao entretientDao;

    @Autowired
    public void setEntretientDao(EntretientDao entrientDao) {
        this.entretientDao = entrientDao;
    }

    public List listAllEntretient() {
        return entretientDao.listAllEntretient();
    }

    public void addEntretient(Entretient entretient) {
        entretientDao.addEntretient(entretient);
    }

    public void updateEntretient(Entretient entretient) {
        entretientDao.updateEntretient(entretient);
    }

    public void delete(Entretient entretient) {
        entretientDao.delete(entretient);
    }

    public Entretient findEntretientById(Entretient entretient) {
        return entretientDao.findEntretientById(entretient);
    }

}