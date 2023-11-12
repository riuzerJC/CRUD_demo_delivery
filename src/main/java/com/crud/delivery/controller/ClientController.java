package com.crud.delivery.controller;

import com.crud.delivery.entity.Client;
import com.crud.delivery.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> getAll(){
        return clientService.getClients();
    }

    @GetMapping("/{clientId}")
    public Optional<Client> getById(@PathVariable("clientId") Long clientId){
        return clientService.getClients(clientId);
    }

    @PostMapping
    public void saveUpdate(@RequestBody Client client){
        clientService.saveOrUpdate(client);
    }

    @DeleteMapping("/{clientId}")
    public void delete(@PathVariable("clientId") Long clientId){
        clientService.delete(clientId);
    }
}
