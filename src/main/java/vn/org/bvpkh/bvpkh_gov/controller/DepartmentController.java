package vn.org.bvpkh.bvpkh_gov.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.org.bvpkh.bvpkh_gov.dtos.DepartmentDTO;
import vn.org.bvpkh.bvpkh_gov.entities.Department;
import vn.org.bvpkh.bvpkh_gov.services.IDepartmentService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/departments")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartmentController {
    private final IDepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Page<Department>> getDepartments(Pageable pageable, @RequestParam String name) {
        return ResponseEntity.ok(departmentService.findAll(name, pageable));
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody DepartmentDTO department) {
        return ResponseEntity.ok(departmentService.save(department));
    }
    @PutMapping
    public ResponseEntity<Department> updateDepartment(@RequestBody DepartmentDTO department) {
        return ResponseEntity.ok(departmentService.save(department));
    }
}
