package com.example.springapp.Repository;

import com.example.springapp.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
    Optional<Object> findById(int medicineId);

    Medicine save(Medicine existingMedicine);

    List<Medicine> findAll();

    boolean existsByMedicineName(String medicineName);
}
