package com.api.gift.repositotires;

import com.api.gift.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    boolean existsEmailClient(String email);
    boolean existsCNPJClient(String cnpj);
}
