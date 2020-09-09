package com.location.service;

import com.location.model.Client;

import java.util.List;

public interface ClientService {
    public List listAllClients();

    public void addClient(Client clien);

    public void updateClient(Client clien);

    public void delete(Client clien);

    public Client findClientById(Client clien);
}
