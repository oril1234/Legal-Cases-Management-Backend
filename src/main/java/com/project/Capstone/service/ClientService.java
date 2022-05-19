package com.project.Capstone.service;

import com.project.Capstone.dao.ClientDao;
import com.project.Capstone.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientDao clientDao;

    @Autowired
    public ClientService(@Qualifier("clientDao") ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public int insertClient(Client client){
        return clientDao.insertClient(client);
    }

    public List<Client> getAllClients() {
        return clientDao.selectAllClients();
    }

    public Client getClientById(int id) {
        return clientDao.selectClientById(id);
    }

    public int deleteClient(int id) {
        return clientDao.deleteClientById(id);
    }

    public int updateClient(int id, Client newClient) {
        return clientDao.updateClientById(id, newClient);
    }
}
