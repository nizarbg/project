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
import com.location.model.Client;

import com.location.service.ClientService;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping(value="/user/Client/", method = RequestMethod.GET, headers="Accept=application/json")
    public ResponseEntity<List<Client>> listAllClients(){
        List<Client> list = clientService.listAllClients();

        if(list.size() == 0){
            return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="/add/Client", method = RequestMethod.POST, headers="Accept=application/json")
    public ResponseEntity<Void> add(@RequestBody Client client){
        clientService.addClient(client);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value="/update/Client/{id}", method = RequestMethod.PUT, headers="Accept=application/json")
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Client client){
        client.setId(id);
        clientService.updateClient(client);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.OK);
    }

    @RequestMapping(value="/delete/Client/{id}", method = RequestMethod.DELETE, headers="Accept=application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") int id, @RequestBody Client client){
        client.setId(id);
        clientService.delete(client);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
    }
}