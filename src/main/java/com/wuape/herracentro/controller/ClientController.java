package com.wuape.herracentro.controller;

import com.wuape.herracentro.bean.Client;
import com.wuape.herracentro.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * Bowpi GT
 * Created by Jose on 8/01/2018.
 */
@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping("/add")
    private ResponseEntity<Client> addClient(@RequestBody Client client) {
        return ResponseEntity.ok(clientRepository.save(client));
    }

    @PutMapping("/{id}")
    private ResponseEntity<Client> updateClient(@PathVariable(name = "id") String id, @RequestBody Client client) {
        Client currentClient = clientRepository.findOne(id);

        Assert.notNull(currentClient, "Client with id [" + id + "] cannot be found.");
        if (!client.getId().equals(id)) {
            client.setId(id);
        }
        client = clientRepository.save(client);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Client> findClientById(@PathVariable(name = "id") String id) {
        Client client = clientRepository.findOne(id);

        Assert.notNull(client, "Client with id [" + id + "] cannot be found.");
        return ResponseEntity.ok(client);
    }

    @GetMapping()
    private Iterable<Client> listAllClients() {
        return clientRepository.findAll();
    }
}
