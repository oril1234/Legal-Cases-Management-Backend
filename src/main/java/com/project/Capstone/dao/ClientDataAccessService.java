package com.project.Capstone.dao;

import com.project.Capstone.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("clientDao")
public class ClientDataAccessService implements ClientDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final static String clientsTableName = "CLIENTS";

    @Override
    public int insertClient(Client client) {
        return jdbcTemplate.update("INSERT INTO " + clientsTableName + " (id,firstname,lastname,email,phoneNumber) VALUES(?,?,?,?,?)",
                client.getId(), client.getFirstName(), client.getLastName(), client.getEmail(), client.getPhoneNumber());
    }

    @Override
    public List<Client> selectAllClients() {
        return jdbcTemplate.query("SELECT * FROM " + clientsTableName, new ClientRowMapper());
    }

    @Override
    public Client selectClientById(int id) {
        return selectAllClients().stream()
               .filter(client -> (client.getId() == id))
               .findFirst()
               .orElseThrow(RuntimeException::new);
    }

    @Override
    public int deleteClientById(int id) {
        return jdbcTemplate.update("DELETE FROM " + clientsTableName + " WHERE id = ?", new Object[] {id});
    }

    /**
     * @param id of the Client we are updating
     * @param client object, updates all of a client's fields
     * @return 1 if the row was updated successfully
     */
    @Override
    public int updateClientById(int id, Client client) {
        return jdbcTemplate.update("UPDATE " + clientsTableName + " SET firstname = ?,lastname = ?, email = ?, phoneNumber =? WHERE id = ?",
                    client.getFirstName(), client.getLastName(), client.getEmail(), client.getPhoneNumber(), id);
    }
}
