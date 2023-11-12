package com.crud.delivery.service;

import com.crud.delivery.entity.Client;
import com.crud.delivery.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public Optional<Client> getClients(Long id){
        return clientRepository.findById(id);
    }

    public void saveOrUpdate(Client client){
        clientRepository.save(client);
    }

    public void delete(Long id){
        clientRepository.deleteById(id);
    }

}
