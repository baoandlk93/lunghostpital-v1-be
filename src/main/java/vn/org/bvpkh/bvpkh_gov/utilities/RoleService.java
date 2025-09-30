package vn.org.bvpkh.bvpkh_gov.utilities;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.org.bvpkh.bvpkh_gov.entities.users.User;
import vn.org.bvpkh.bvpkh_gov.services.IUserService;

@Service
public class RoleService implements IUserService {
    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void remove(Long id) {

    }
}
