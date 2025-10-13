package vn.org.bvpkh.bvpkh_gov.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.org.bvpkh.bvpkh_gov.dtos.RoleDTO;
import vn.org.bvpkh.bvpkh_gov.entities.users.Role;

public interface IRoleService {
    Role findByName(String role);

    Page<RoleDTO> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Role findById(Long id);
    Role save(RoleDTO role);
    void delete(Role role);

}
