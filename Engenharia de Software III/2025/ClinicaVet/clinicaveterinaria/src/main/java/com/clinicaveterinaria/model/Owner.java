package com.clinicaveterinaria.model;

import java.time.LocalDate;
import java.util.List;

public class Owner {
    private String id;
    private String name;
    private LocalDate birthDate;
    private String address;
    private String phone;
    private String cpf;
    private List<String> petIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<String> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<String> petIds) {
        this.petIds = petIds;
    }
}