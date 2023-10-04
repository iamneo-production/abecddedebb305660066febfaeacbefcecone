package com.example.springapp.MedService.MedService;

import com.MedicineApp.Medicine.Application.Model.Medicine;

import java.util.List;

public interface MedService {

    boolean addMedicine(Medicine medicine);

        Medicine updateMedicine(int medicineId, Medicine updatedMedicine);

            List<Medicine> getAllMedicines();
            }
