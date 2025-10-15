package vn.org.bvpkh.bvpkh_gov.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.org.bvpkh.bvpkh_gov.dtos.EquipmentDTO;
import vn.org.bvpkh.bvpkh_gov.services.impl.EquipmentService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/equipments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EquipmentController {
    private final EquipmentService equipmentService;

    @GetMapping()
    public ResponseEntity<Page<EquipmentDTO>> getEquipments(Pageable pageable, @Param(value = "name") String name) {
        return ResponseEntity.ok(equipmentService.search(name, pageable));
    }

    @PostMapping
    public ResponseEntity<EquipmentDTO> createEquipment(@RequestBody EquipmentDTO equipmentDTO) {
        return new ResponseEntity<>(equipmentService.save(equipmentDTO), HttpStatus.CREATED);
    }
}
