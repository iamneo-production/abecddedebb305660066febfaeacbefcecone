package com.example.springapp.Service;

import com.example.springapp.model.Medicine;

import java.util.List;

public interface MedicineService {

    boolean addMedicine(Medicine medicine);

    Medicine updateMedicine(int medicineId, Medicine updatedMedicine);

    List<Medicine> getAllMedicines();

}
