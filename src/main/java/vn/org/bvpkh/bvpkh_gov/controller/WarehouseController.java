package vn.org.bvpkh.bvpkh_gov.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.org.bvpkh.bvpkh_gov.entities.management_equipment.Warehouse;
import vn.org.bvpkh.bvpkh_gov.services.IWarehouService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/warehouses")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WarehouseController {
    private final IWarehouService warehouService;

    @GetMapping
    public ResponseEntity<Page<Warehouse>> getAllWarehouses(Pageable pageable) {
        Page<Warehouse> warehouses = warehouService.findAll(pageable);
        return ResponseEntity.ok(warehouses);
    }

    @PostMapping
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        Warehouse warehouse1 = warehouService.save(warehouse);
        return ResponseEntity.ok(warehouse1);
    }
}
