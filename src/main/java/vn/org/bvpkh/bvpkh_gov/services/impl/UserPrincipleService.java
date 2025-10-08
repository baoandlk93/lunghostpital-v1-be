package vn.org.bvpkh.bvpkh_gov.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.org.bvpkh.bvpkh_gov.entities.users.User;
import vn.org.bvpkh.bvpkh_gov.repositories.IUserRepository;
import vn.org.bvpkh.bvpkh_gov.security.UserPrincipal;
import vn.org.bvpkh.bvpkh_gov.services.IUserPrincipleService;

@Service
@RequiredArgsConstructor
public class UserPrincipleService implements IUserPrincipleService {
    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found with username or email: " + username));
        return UserPrincipal.create(user);
    }
}
