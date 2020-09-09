package com.location.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.dao.EmployeDao;
import com.location.model.Employe;

@Service
public class EmployeServiceImpl implements EmployeService {

    EmployeDao employeDao;

    @Autowired
    public void setEmployeDao(EmployeDao employeDao) {
        this.employeDao = employeDao;
    }

    public List listAllEmploye() {
        return employeDao.listAllEmploye();
    }

    public void addEmploye(Employe employe) {
        employeDao.addEmploye(employe);
    }

    public void updateEmploye(Employe employe) {
        employeDao.updateEmploye(employe);
    }

    public void delete(Employe employe) {
        employeDao.delete(employe);
    }

    public Employe findEmployeById(Employe employe) {
        return employeDao.findEmployeById(employe);
    }

}