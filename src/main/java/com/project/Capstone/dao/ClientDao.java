package com.project.Capstone.dao;

import com.project.Capstone.model.Client;

import java.util.List;

public interface ClientDao {

    int insertClient(Client client);

    List<Client> selectAllClients();

    Client selectClientById(int id);

    int deleteClientById(int id);

    int updateClientById(int id, Client client);
}
