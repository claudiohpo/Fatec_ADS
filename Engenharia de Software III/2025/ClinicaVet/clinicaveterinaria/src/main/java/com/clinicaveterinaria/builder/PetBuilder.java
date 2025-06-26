package com.clinicaveterinaria.builder;

import com.clinicaveterinaria.model.Pet;
import java.time.LocalDate;
import java.util.List;

// Builder Pattern: construção de Pet
public class PetBuilder {
    private Pet pet = new Pet();

    public PetBuilder withName(String name) {
        pet.setName(name);
        return this;
    }

    public PetBuilder withBreed(String breed) {
        pet.setBreed(breed);
        return this;
    }

    public PetBuilder withBirthDate(LocalDate bd) {
        pet.setBirthDate(bd);
        return this;
    }

    public PetBuilder withColor(String color) {
        pet.setColor(color);
        return this;
    }

    public PetBuilder withWeight(double w) {
        pet.setWeight(w);
        return this;
    }

    public PetBuilder withAllergies(String allergies) {
        pet.setAllergies(allergies);
        return this;
    }

    public PetBuilder withOwnerId(String ownerId) {
        pet.setOwnerId(ownerId);
        return this;
    }

    public PetBuilder withMedicationIds(List<String> meds) {
        pet.setMedicationIds(meds);
        return this;
    }

    public Pet build() {
        return pet;
    }
}