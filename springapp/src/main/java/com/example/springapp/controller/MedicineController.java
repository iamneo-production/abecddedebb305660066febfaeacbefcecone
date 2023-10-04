package com.example.springapp.controller;

import com.example.springapp.Service.MedicineService;
import com.example.springapp.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MedicineController {
    @Autowired
    MedicineService medicineService;

    @PostMapping("/medicines")

    public ResponseEntity<Boolean> addMedicine(@RequestBody Medicine medicine) {
        boolean result = medicineService.addMedicine(medicine);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{medicineId}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable int medicineId,
            @RequestBody Medicine updatedMedicine) {
        Medicine updated = medicineService.updateMedicine(medicineId, updatedMedicine);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}