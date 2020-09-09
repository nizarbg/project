package com.location.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.location.model.Employe;

import com.location.service.EmployeService;

@RestController
public class EmployeController {

    @Autowired
    EmployeService employeService;

    @RequestMapping(value="/user/Employe/", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<Employe>> listAllClients(){
        List<Employe> list = employeService.listAllEmploye();

        if(list.size() == 0){
            return new ResponseEntity<List<Employe>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Employe>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="/add/Employe/", method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Void> add(@RequestBody Employe employe){
        employeService.addEmploye(employe);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/Employe/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Employe employe){
        employe.setId(id);
        employeService.updateEmploye(employe);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/Employe/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Employe employe){
        employe.setId(id);
        employeService.delete(employe);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}