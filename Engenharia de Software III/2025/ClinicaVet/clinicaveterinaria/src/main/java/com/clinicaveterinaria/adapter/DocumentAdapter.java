package com.clinicaveterinaria.adapter;

import com.clinicaveterinaria.model.*;
import org.bson.Document;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// Adapter Pattern: mapeia Document <-> POJO para todas as entidades
public class DocumentAdapter {
    // Owner
    public static Owner toOwner(Document doc) {
        Owner o = new Owner();
        o.setId(doc.getObjectId("_id").toHexString());
        o.setName(doc.getString("name"));
        o.setBirthDate(LocalDate.parse(doc.getString("birthDate")));
        o.setAddress(doc.getString("address"));
        o.setPhone(doc.getString("phone"));
        o.setCpf(doc.getString("cpf"));
        o.setPetIds((List<String>) doc.get("petIds"));
        return o;
    }

    public static Document fromOwner(Owner o) {
        return new Document("name", o.getName())
                .append("birthDate", o.getBirthDate().toString())
                .append("address", o.getAddress())
                .append("phone", o.getPhone())
                .append("cpf", o.getCpf())
                .append("petIds", o.getPetIds());
    }

    // Pet
    public static Pet toPet(Document doc) {
        Pet p = new Pet();
        p.setId(doc.getObjectId("_id").toHexString());
        p.setName(doc.getString("name"));
        p.setBreed(doc.getString("breed"));
        p.setBirthDate(LocalDate.parse(doc.getString("birthDate")));
        p.setColor(doc.getString("color"));
        p.setWeight(doc.getDouble("weight"));
        p.setAllergies(doc.getString("allergies"));
        p.setOwnerId(doc.getString("ownerId"));
        p.setMedicationIds((List<String>) doc.get("medicationIds"));
        return p;
    }

    public static Document fromPet(Pet p) {
        return new Document("name", p.getName())
                .append("breed", p.getBreed())
                .append("birthDate", p.getBirthDate().toString())
                .append("color", p.getColor())
                .append("weight", p.getWeight())
                .append("allergies", p.getAllergies())
                .append("ownerId", p.getOwnerId())
                .append("medicationIds", p.getMedicationIds());
    }

    // Medication
    public static Medication toMedication(Document doc) {
        Medication m = new Medication();
        m.setId(doc.getObjectId("_id").toHexString());
        m.setName(doc.getString("name"));
        m.setManufacturer(doc.getString("manufacturer"));
        m.setDosage(doc.getDouble("dosage"));
        m.setUnit(doc.getString("unit"));
        m.setStock(doc.getInteger("stock"));
        return m;
    }

    public static Document fromMedication(Medication m) {
        return new Document("name", m.getName())
                .append("manufacturer", m.getManufacturer())
                .append("dosage", m.getDosage())
                .append("unit", m.getUnit())
                .append("stock", m.getStock());
    }

    // Appointment
    public static Appointment toAppointment(Document doc) {
        Appointment a = new Appointment();
        a.setId(doc.getObjectId("_id").toHexString());
        a.setDate(LocalDateTime.parse(doc.getString("date")));
        a.setPetId(doc.getString("petId"));
        a.setOwnerId(doc.getString("ownerId"));
        a.setVeterinarianId(doc.getString("veterinarianId"));
        a.setAnamnese(doc.getString("anamnese"));
        return a;
    }

    public static Document fromAppointment(Appointment a) {
        return new Document("date", a.getDate().toString())
                .append("petId", a.getPetId())
                .append("ownerId", a.getOwnerId())
                .append("veterinarianId", a.getVeterinarianId())
                .append("anamnese", a.getAnamnese());
    }

    // Consultation
    public static Consultation toConsultation(Document doc) {
        Consultation c = new Consultation();
        c.setId(doc.getObjectId("_id").toHexString());
        c.setPetId(doc.getString("petId"));
        c.setVeterinarianId(doc.getString("veterinarianId"));
        c.setDescription(doc.getString("description"));
        c.setPrescription(doc.getString("prescription"));
        c.setDate(doc.getString("date"));
        return c;
    }

    public static Document fromConsultation(Consultation c) {
        return new Document("petId", c.getPetId())
                .append("veterinarianId", c.getVeterinarianId())
                .append("description", c.getDescription())
                .append("prescription", c.getPrescription())
                .append("date", c.getDate());
    }

    // Veterinarian
    public static Veterinarian toVeterinarian(Document doc) {
        Veterinarian v = new Veterinarian();
        v.setId(doc.getObjectId("_id").toHexString());
        v.setNome(doc.getString("nome"));
        v.setCrmv(doc.getString("crmv"));
        v.setEspecialidade(doc.getString("especialidade"));
        v.setTelefone(doc.getString("telefone"));
        String dataStr = doc.getString("dataNascimento");
        if (dataStr != null) {
            v.setDataNascimento(LocalDate.parse(dataStr));
        }
        return v;
    }

    public static Document fromVeterinarian(Veterinarian v) {
        Document doc = new Document("nome", v.getNome())
                .append("crmv", v.getCrmv())
                .append("especialidade", v.getEspecialidade())
                .append("telefone", v.getTelefone());
        if (v.getDataNascimento() != null) {
            doc.append("dataNascimento", v.getDataNascimento().toString());
        }
        return doc;
    }
}
