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
import com.location.model.Voiture;

import com.location.service.VoitureService;

@RestController
public class VoitureController {

    @Autowired
    VoitureService voitureService;

    @RequestMapping(value="/user/voiture/", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<Voiture>> listAllVoiture(){
        List<Voiture> list = voitureService.listAllVoiture();

        if(list.size() == 0){
            return new ResponseEntity<List<Voiture>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Voiture>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="/add/voiture/", method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Void> add(@RequestBody Voiture voiture){
        voitureService.addVoiture(voiture);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/voiture/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Voiture voiture){
        voiture.setId(id);
        voitureService.updateVoiture(voiture);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/voiture/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Voiture voiture){
        voiture.setId(id);
        voitureService.delete(voiture);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}