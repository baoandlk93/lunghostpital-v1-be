package vn.org.bvpkh.bvpkh_gov.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.org.bvpkh.bvpkh_gov.entities.users.Role;
import vn.org.bvpkh.bvpkh_gov.entities.users.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    @Query("SELECT u FROM User u JOIN u.roles r WHERE r = :role")
    Page<User> findUsersByRole(@Param("role") Role role, Pageable pageable);

    Page<User> findUsersByUsernameContains(String username, Pageable pageable);

    Page<User> findAllByUsername(String username);


}
