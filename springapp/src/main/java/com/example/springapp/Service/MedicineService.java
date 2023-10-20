package com.example.springapp.service;

import java.util.HashMap;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.springapp.model.Medicine;

@Service
public class MedicineService {

    private final Map<Integer, Medicine> medicines = new HashMap<>();
    private int nextMedicineId = 1;

    public boolean addMedicine(Medicine medicine) {
        medicine.setMedicineId(nextMedicineId++);
        medicines.put(medicine.getMedicineId(), medicine);
        return true;
    }

    public Medicine updateMedicine(int medicineId, Medicine updatedMedicine) {
        if (medicines.containsKey(medicineId)) {
            Medicine existingMedicine = medicines.get(medicineId);
            existingMedicine.setMedicineName(updatedMedicine.getMedicineName());
            existingMedicine.setPrice(updatedMedicine.getPrice());
            existingMedicine.setQuantity(updatedMedicine.getQuantity());
            existingMedicine.setDescription(updatedMedicine.getDescription());
            return existingMedicine;
        }
        return null;
    }

}
