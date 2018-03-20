package com.wuape.herracentro.controller;

import com.wuape.herracentro.bean.ClientStore;
import com.wuape.herracentro.repository.ClientStoreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * Bowpi GT
 * Created by Jose on 8/01/2018.
 */
@RestController
@RequestMapping("/client-store")
public class ClientStoreController {

    private final ClientStoreRepository clientStoreRepository;

    public ClientStoreController(ClientStoreRepository clientStoreRepository) {
        this.clientStoreRepository = clientStoreRepository;
    }

    @PostMapping("/add")
    private ResponseEntity<ClientStore> addClientStore(@RequestBody ClientStore clientStore) {
        return ResponseEntity.ok(clientStoreRepository.save(clientStore));
    }

    @PutMapping("/{id}")
    private ResponseEntity<ClientStore> updateClientStore(@PathVariable(name = "id") Long id, @RequestBody ClientStore clientStore) {
        ClientStore currentClientStore = clientStoreRepository.findOne(id);

        Assert.notNull(currentClientStore, "Client Store with id [" + id + "] cannot be found.");
        if (clientStore.getId() == null || clientStore.getId() == 0) {
            clientStore.setId(id);
        }
        clientStore = clientStoreRepository.save(clientStore);
        return ResponseEntity.ok(clientStore);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ClientStore> findClientStoreById(@PathVariable(name = "id") Long id) {
        ClientStore clientStore = clientStoreRepository.findOne(id);

        Assert.notNull(clientStore, "Client Store with id [" + id + "] cannot be found.");
        return ResponseEntity.ok(clientStore);
    }

    @GetMapping()
    private Iterable<ClientStore> listAllClientStores() {
        return clientStoreRepository.findAll();
    }
}
