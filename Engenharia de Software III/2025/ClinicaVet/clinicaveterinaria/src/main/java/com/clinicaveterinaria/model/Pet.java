package com.clinicaveterinaria.model;

import java.time.LocalDate;
import java.util.List;

public class Pet {
    private String id;
    private String name;
    private String breed;
    private LocalDate birthDate;
    private String color;
    private double weight;
    private String allergies;
    private String ownerId;
    private List<String> medicationIds;

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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public List<String> getMedicationIds() {
        return medicationIds;
    }

    public void setMedicationIds(List<String> medicationIds) {
        this.medicationIds = medicationIds;
    }
}