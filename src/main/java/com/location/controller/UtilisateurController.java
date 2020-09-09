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
import com.location.model.Utilisateur;

import com.location.service.UtilisateurService;

@RestController
public class UtilisateurController {

    @Autowired
    UtilisateurService utilisateurService;

    @RequestMapping(value="/user/utilisateur/", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<Utilisateur>> listAllUtilisateur(){
        List<Utilisateur> list = utilisateurService.listAllUtilisateur();

        if(list.size() == 0){
            return new ResponseEntity<List<Utilisateur>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Utilisateur>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="/add/utilisateur/", method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Void> add(@RequestBody Utilisateur utilisateur){
        utilisateurService.addUtilisateur(utilisateur);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/utilisateur/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Utilisateur utilisateur){
        utilisateur.setId(id);
        utilisateurService.updateUtilisateur(utilisateur);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/utilisateur/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Utilisateur utilisateur){
        utilisateur.setId(id);
        utilisateurService.delete(utilisateur);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}