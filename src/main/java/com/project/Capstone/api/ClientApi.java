package com.project.Capstone.api;

import com.project.Capstone.model.Client;
import com.project.Capstone.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/client")
@RestController
public class ClientApi {

    private final ClientService clientService;

    @Autowired
    public ClientApi(ClientService clientService) {
        this.clientService = clientService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void insertClient(@RequestBody Client client){
        clientService.insertClient(client);
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "{id}")
    public Client getClientById(@PathVariable("id") int id) {
        return clientService.getClientById(id);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "{id}")
    public int deleteClientById(@PathVariable("id") int id) {
        return clientService.deleteClient(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "{id}")
    public int updateClientById(@PathVariable("id") int id, @RequestBody Client clientToUpdate) {
        return clientService.updateClient(id, clientToUpdate);
    }
}
