package com.api.gift.controllers;

import com.api.gift.dtos.ClientDto;
import com.api.gift.models.Client;
import com.api.gift.services.ClientService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/v1/clients")
public class ClientController {
    final ClientService service;
    public ClientController(ClientService service) {
        this.service = service;
    }

    public ResponseEntity<Object> saveClient(@RequestBody @Valid ClientDto clientDto){
        if(service.existsEmailClient(clientDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflit: this email is already in use");
        }

        if(service.existsCNPJClient(clientDto.getCnpj())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflit:this CNPJ is already in use");
        }

        var client = new Client();
        BeanUtils.copyProperties(clientDto, client);
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(client));
    }




}
