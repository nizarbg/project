package com.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.dao.ClientDao;
import com.location.model.Client;

@Service
public class ClientServiceImpl implements ClientService {

    ClientDao clientDao;

    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public List listAllClients() {
        return clientDao.listAllClients();
    }

    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    public void updateClient(Client client) {
        clientDao.updateClient(client);
    }

    public void delete(Client client) {
        clientDao.delete(client);
    }

    public Client findClientById(Client client) {
        return clientDao.findclientById(client);
    }

}