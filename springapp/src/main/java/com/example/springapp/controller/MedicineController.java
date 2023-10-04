package com.MedicineApp.Medicine.Application.Controller;

import com.MedicineApp.Medicine.Application.MedService.MedService;
import com.MedicineApp.Medicine.Application.Model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MedicineController {
    @Autowired
        MedService medService;
            @PostMapping("/medicines")
                public ResponseEntity<Boolean> addMedicine(@RequestBody Medicine medicine) {
                        boolean result = medService.addMedicine(medicine);
                                return ResponseEntity.ok(result);
                                    }

                                        @PutMapping("/{medicineId}")
                                            public ResponseEntity<Medicine> updateMedicine(@PathVariable int medicineId, @RequestBody Medicine updatedMedicine) {
                                                    Medicine updated = medService.updateMedicine(medicineId, updatedMedicine);
                                                            if (updated != null) {
                                                                        return ResponseEntity.ok(updated);
                                                                                } else {
                                                                                            return ResponseEntity.notFound().build();
                                                                                                    }
                                                                                                        }
                                                                                                        }
                                                                                                        