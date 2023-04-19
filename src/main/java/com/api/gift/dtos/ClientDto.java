package com.api.gift.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ClientDto {
    @NotBlank
    private  String name;

    @NotBlank
    @Email
    private String email;

    private String cnpj;

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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
