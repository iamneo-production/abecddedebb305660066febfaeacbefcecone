package com.example.springapp.Service;

import com.example.springapp.Repository.MedicineRepository;
import com.example.springapp.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    MedicineRepository medicineRepository;

    @Override
    public boolean addMedicine(Medicine medicine) {
        boolean medicineExists = medicineRepository.existsByMedicineName(medicine.getMedicineName());

        if (!medicineExists) {
            // Medicine doesn't exist, save it
            medicineRepository.save(medicine);
            return true;
        } else {
            // Medicine with the same name already exists
            return false;
        }
    }

    @Override
    public Medicine updateMedicine(int medicineId, Medicine updatedMedicine) {
        Medicine existingMedicine = (Medicine) medicineRepository.findById(medicineId).orElse(null);

        if (existingMedicine != null) {
            existingMedicine.setMedicineName(updatedMedicine.getMedicineName());
            existingMedicine.setPrice(updatedMedicine.getPrice());
            existingMedicine.setQuantity(updatedMedicine.getQuantity());
            existingMedicine.setDescription(updatedMedicine.getDescription());

            return medicineRepository.save(existingMedicine);
        } else {
            return null;
        }
    }

    @Override
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

}
