package vn.org.bvpkh.bvpkh_gov.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.org.bvpkh.bvpkh_gov.dtos.RoleDTO;
import vn.org.bvpkh.bvpkh_gov.entities.users.Role;
import vn.org.bvpkh.bvpkh_gov.repositories.IRoleRepository;
import vn.org.bvpkh.bvpkh_gov.services.IRoleService;

@Service
@AllArgsConstructor
public class RoleService implements IRoleService {
    private final IRoleRepository roleRepository;

    @Override
    public Role findByName(String role) {
        return roleRepository.findByName(role);
    }

    @Override
    public Page<RoleDTO> findByNameContainingIgnoreCase(String name, Pageable pageable) {
        return roleRepository.findAll(pageable).map(role -> RoleDTO.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build());
    }

    @Override
    public Role findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public Role save(RoleDTO role) {
        Role existing = roleRepository.findByName(role.getName());
        if (existing == null) {
            Role roleEntity = new Role();
            roleEntity.setName(role.getName());
            roleEntity.setDescription(role.getDescription());
            return roleRepository.save(roleEntity);
        } else return null;
    }

    @Override
    public void delete(Role role) {

    }
}
