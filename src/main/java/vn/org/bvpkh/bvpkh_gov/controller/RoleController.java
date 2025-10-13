package vn.org.bvpkh.bvpkh_gov.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.org.bvpkh.bvpkh_gov.dtos.RoleDTO;
import vn.org.bvpkh.bvpkh_gov.entities.users.Role;
import vn.org.bvpkh.bvpkh_gov.services.IRoleService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoleController {
    private final IRoleService roleService;

    @GetMapping
    public ResponseEntity<Page<RoleDTO>> findAll(Pageable pageable, @DefaultValue("") String roleName) {
        Page<RoleDTO> roles = roleService.findByNameContainingIgnoreCase(roleName, pageable);
        return ResponseEntity.ok(roles);
    }

    @PostMapping
    public ResponseEntity<Role> save(@RequestBody RoleDTO role) {
        return ResponseEntity.ok(roleService.save(role));
    }
}
