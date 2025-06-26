package com.clinicaveterinaria.facade;

import com.clinicaveterinaria.dao.*;
import com.clinicaveterinaria.model.*;
import java.util.List;

// Facade Pattern: 
public class ClinicFacade {
    private OwnerDAO ownerDAO = new OwnerDAO();
    private PetDAO petDAO = new PetDAO();
    private MedicationDAO medDAO = new MedicationDAO();
    private AppointmentDAO appDAO = new AppointmentDAO();
    private ConsultationDAO consDAO = new ConsultationDAO();
    private VeterinarianDAO vetDAO = new VeterinarianDAO();

    // Owner
    public void addOwner(Owner o) {
        ownerDAO.insert(o);
    }

    public List<Owner> getOwners() {
        return ownerDAO.findAll();
    }

    public Owner getOwner(String id) {
        return ownerDAO.findById(id);
    }

    public void updateOwner(String id, Owner o) {
        ownerDAO.update(id, o);
    }

    public void removeOwner(String id) {
        ownerDAO.delete(id);
    }

    // Pet
    public void addPet(Pet p) {
        petDAO.insert(p);
    }

    public List<Pet> getPets() {
        return petDAO.findAll();
    }

    public Pet getPet(String id) {
        return petDAO.findById(id);
    }

    public void updatePet(String id, Pet p) {
        petDAO.update(id, p);
    }

    public void removePet(String id) {
        petDAO.delete(id);
    }

    // Medication
    public void addMedication(Medication m) {
        medDAO.insert(m);
    }

    public List<Medication> getMedication() {
        return medDAO.findAll();
    }

    public Medication getMedication(String id) {
        return medDAO.findById(id);
    }

    public void updateMedication(String id, Medication m) {
        medDAO.update(id, m);
    }

    public void removeMedication(String id) {
        medDAO.delete(id);
    }

    // Appointment
    public void addAppointment(Appointment a) {
        appDAO.insert(a);
    }

    public List<Appointment> getAppointments() {
        return appDAO.findAll();
    }

    public Appointment getAppointment(String id) {
        return appDAO.findById(id);
    }

    public void updateAppointment(String id, Appointment a) {
        appDAO.update(id, a);
    }

    public void removeAppointment(String id) {
        appDAO.delete(id);
    }

    // Consultation
    public void addConsultation(Consultation c) {
        consDAO.insert(c);
    }

    public List<Consultation> getConsultations() {
        return consDAO.findAll();
    }

    public Consultation getConsultationById(String id) {
        return consDAO.findById(id);
    }

    public void updateConsultation(String id, Consultation c) {
        consDAO.update(id, c);
    }

    public void removeConsultation(String id) {
        consDAO.delete(id);
    }

    // Veterinarian
    public void addVeterinarian(Veterinarian v) {
        vetDAO.insert(v);
    }

    public List<Veterinarian> getVeterinarians() {
        return vetDAO.findAll();
    }

    public Veterinarian getVeterinarian(String id) {
        return vetDAO.findById(id);
    }

    public void updateVeterinarian(String id, Veterinarian v) {
        vetDAO.update(id, v);
    }

    public void removeVeterinarian(String id) {
        vetDAO.delete(id);
    }
}