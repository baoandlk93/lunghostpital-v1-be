package vn.org.bvpkh.bvpkh_gov.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.org.bvpkh.bvpkh_gov.entities.users.Role;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String role);

    Page<Role> findAllByNameContains(String name, Pageable pageable);
}
