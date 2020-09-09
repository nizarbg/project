package com.location.dao;

import com.location.model.Client;

import java.util.List;

public interface ClientDao {
    public List listAllClients();

    public void addClient(Client clien);

    public void updateClient(Client clien);

    public void delete(Client clien);

    public Client findclientById(Client clien);
}
