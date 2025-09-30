package vn.org.bvpkh.bvpkh_gov.utilities;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.org.bvpkh.bvpkh_gov.entities.users.User;
import vn.org.bvpkh.bvpkh_gov.repositories.IUserRepository;
import vn.org.bvpkh.bvpkh_gov.services.IUserService;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }
}
