package com.api.gift.models;

import org.springframework.context.annotation.EnableMBeanExport;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_clients")
public class Client implements Serializable {

    private static  final long serialVersionUID =1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String CNPJ;

    public Client() {
    }

    public Client(UUID id, String name, String email, String CNPJ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.CNPJ = CNPJ;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}
