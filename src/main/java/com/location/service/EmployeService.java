package com.location.service;

import com.location.model.Employe;

import java.util.List;

public interface EmployeService {
    public List listAllEmploye();

    public void addEmploye(Employe emp);

    public void updateEmploye(Employe emp);

    public void delete(Employe emp);

    public Employe findEmployeById(Employe emp);
}
