package vn.org.bvpkh.bvpkh_gov.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.org.bvpkh.bvpkh_gov.dtos.EquipmentDTO;
import vn.org.bvpkh.bvpkh_gov.services.impl.EquipmentService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/equipments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EquipmentController {
    private final EquipmentService equipmentService;

    @GetMapping()
    public ResponseEntity<Page<EquipmentDTO>> getEquipments(Pageable pageable) {
        return ResponseEntity.ok(equipmentService.search("", pageable));
    }
}
