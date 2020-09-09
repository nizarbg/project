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
import com.location.model.Modele;

import com.location.service.ModeleService;

@RestController
public class ModeleController {

    @Autowired
    ModeleService modeleService;

    @RequestMapping(value="/user/modele/", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<Modele>> listAllClients(){
        List<Modele> list = modeleService.listAllModele();

        if(list.size() == 0){
            return new ResponseEntity<List<Modele>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Modele>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="/add/modele", method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Void> add(@RequestBody Modele modele){
        modeleService.addModele(modele);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/modele/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Modele modele){
        modele.setId(id);
        modeleService.updateModele(modele);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/modele/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Modele modele){
        modele.setId(id);
        modeleService.delete(modele);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}