package vn.org.bvpkh.bvpkh_gov.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.org.bvpkh.bvpkh_gov.dtos.CategoryEquipmentDTO;
import vn.org.bvpkh.bvpkh_gov.entities.management_equipment.EquipmentCategory;
import vn.org.bvpkh.bvpkh_gov.services.impl.EquipmentCategoryService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryEquipmentController {
    private final EquipmentCategoryService equipmentCategoryService;

    @GetMapping
    public ResponseEntity<Page<EquipmentCategory>> findAll(Pageable pageable) {
        return ResponseEntity.ok(equipmentCategoryService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<EquipmentCategory> create(@RequestBody CategoryEquipmentDTO categoryEquipmentDTO) {
        return ResponseEntity.ok(equipmentCategoryService.save(categoryEquipmentDTO));
    }
}
