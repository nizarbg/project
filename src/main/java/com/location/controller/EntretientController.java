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
import com.location.model.Entretient;

import com.location.service.EntretientService;

@RestController
public class EntretientController {

    @Autowired
    EntretientService entretientService;

    @RequestMapping(value="/user/Entretient/", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<Entretient>> listAllEntretient(){
        List<Entretient> list = entretientService.listAllEntretient();

        if(list.size() == 0){
            return new ResponseEntity<List<Entretient>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Entretient>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="/add/Entretient/", method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Void> add(@RequestBody Entretient entretient){
        entretientService.addEntretient(entretient);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/Entretient/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Entretient entretient){
        entretient.setId(id);
        entretientService.updateEntretient(entretient);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/Entretient/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Entretient entretient){
        entretient.setId(id);
        entretientService.delete(entretient);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}