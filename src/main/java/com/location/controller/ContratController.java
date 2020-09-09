package com.location.controller;

import java.util.List;

import com.location.model.Contrat;
import com.location.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class ContratController {

    @Autowired
    ContratService contratService;

    @RequestMapping(value="/user/Contrat", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<Contrat>> listAllContrats(){
        List<Contrat> list = contratService.listAllContrat();

        if(list.size() == 0){
            return new ResponseEntity<List<Contrat>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Contrat>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="/add/Contrat/", method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Void> add(@RequestBody Contrat contrat){
        contratService.addContrat(contrat);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/Contrat/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Contrat contrat){
        contrat.setId(id);
        contratService.updateContrat(contrat);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/Contrat/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Contrat contrat){
        contrat.setId(id);
        contratService.delete(contrat);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}