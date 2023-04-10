package com.javapoint.habits.service;

import com.javapoint.habits.model.Client;
import com.javapoint.habits.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Client client) {
        repository.save(client);
    }

    @Override
    public List<Client> readAll() {
        return (List<Client>) repository.findAll();
    }

    @Override
    public Client read(int id) {
        return repository.findById( id ).orElseGet( null );
    }

    @Override
    public boolean update(Client client, int id) {
        if (repository.existsById(id)) {
            client.setId(id);
            repository.save(client);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
