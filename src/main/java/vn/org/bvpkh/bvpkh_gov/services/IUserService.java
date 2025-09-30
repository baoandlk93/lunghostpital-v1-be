package vn.org.bvpkh.bvpkh_gov.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.org.bvpkh.bvpkh_gov.entities.users.User;

public interface IUserService {
    Page<User> findAll(Pageable pageable);

    User findById(Long id);

    void save(User user);

    void remove(Long id);

}
