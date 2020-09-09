package com.location.controller;

import java.util.List;

import com.location.model.Contrat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.location.model.Document;

import com.location.service.DocumentService;

@RestController
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @RequestMapping(value="/user/Document/", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<Document>> listAllDocument(){
        List<Document> list = documentService.listAllDocument();

        if(list.size() == 0){
            return new ResponseEntity<List<Document>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Document>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="/add/Document/", method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Void> add(@RequestBody Document document){
        documentService.addDocument(document);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/Document/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Document document){
        document.setId(id);
        documentService.updateDocument(document);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/Document/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Document document){
        document.setId(id);
        documentService.delete(document);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}