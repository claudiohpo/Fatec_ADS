package com.clinicaveterinaria.factory;

import com.clinicaveterinaria.model.Medication;

// Factory Pattern:
public class MedicationFactory {
    public static Medication create(String name, String manufacturer, double dosage, String unit, int stock) {
        Medication m = new Medication();
        m.setName(name);
        m.setManufacturer(manufacturer);
        m.setDosage(dosage);
        m.setUnit(unit);
        m.setStock(stock);
        return m;
    }
}