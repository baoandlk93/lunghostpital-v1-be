package vn.org.bvpkh.bvpkh_gov.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.org.bvpkh.bvpkh_gov.dtos.LoginUserDTO;
import vn.org.bvpkh.bvpkh_gov.dtos.RegisterUserDTO;
import vn.org.bvpkh.bvpkh_gov.dtos.ResponseDto;
import vn.org.bvpkh.bvpkh_gov.dtos.UserDTO;
import vn.org.bvpkh.bvpkh_gov.entities.users.Role;
import vn.org.bvpkh.bvpkh_gov.entities.users.User;
import vn.org.bvpkh.bvpkh_gov.repositories.IRoleRepository;
import vn.org.bvpkh.bvpkh_gov.repositories.IUserRepository;
import vn.org.bvpkh.bvpkh_gov.security.jwt.JwtTokenProvider;
import vn.org.bvpkh.bvpkh_gov.services.IUserService;
import vn.org.bvpkh.bvpkh_gov.utilities.TokenCache;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final IUserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final TokenCache tokenCache;
    private final IRoleRepository roleRepository;

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

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public Page<User> findByUsernameContaining(String username, Pageable pageable) {
        return userRepository.findUsersByUsernameContains(username, pageable);
    }

    @Override
    public ResponseDto registerUser(RegisterUserDTO registerUserDTO) {
        Role roleRepositoryByName = roleRepository.findByName(registerUserDTO.getRole());
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleRepositoryByName);
        String password = passwordEncoder.encode(registerUserDTO.getPassword());
        User user = User.builder()
                .password(password)
                .fullName(registerUserDTO.getFullName())
                .username(registerUserDTO.getUsername())
                .phoneNumber(registerUserDTO.getPhoneNumber())
                .email(registerUserDTO.getEmail())
                .roles(roleSet)
                .build();
        try {
            userRepository.save(user);

            return ResponseDto.builder()
                    .data(user)
                    .message("Success")
                    .status(HttpStatus.OK)
                    .build();
        } catch (Exception e) {
            return ResponseDto.builder()
                    .data(null)
                    .message("Fail try again !")
                    .status(HttpStatus.BAD_REQUEST)
                    .build();

        }

    }

    @Override
    public ResponseDto login(LoginUserDTO loginUserDTO) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginUserDTO.getUsername(), loginUserDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        List<String> roles = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority) // Lấy tên của từng quyền
                .collect(Collectors.toList()); // Thu thập vào danh sách
        String token = jwtTokenProvider.generateToken(authentication);
        tokenCache.addToken(jwtTokenProvider.getUsernameFromJWT(token), token);
        return ResponseDto.builder()
                .data(UserDTO.builder()
                        .username(SecurityContextHolder.getContext().getAuthentication().getName())
                        .accessToken(token)
                        .roles(roles)
                        .build())
                .build();
    }
}
