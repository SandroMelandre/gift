package com.api.gift.services;

import com.api.gift.models.Client;
import com.api.gift.repositotires.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public Client save(Client client) {
        return repository.save(client);
    }

    public boolean existsEmailClient(String email) {
        return repository.existsEmailClient(email);
    }


    public boolean existsCNPJClient(String cnpj) {
        return repository.existsCNPJClient(cnpj);
    }
}
