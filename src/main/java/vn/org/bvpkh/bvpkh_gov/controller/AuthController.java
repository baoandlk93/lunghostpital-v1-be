package vn.org.bvpkh.bvpkh_gov.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.org.bvpkh.bvpkh_gov.dtos.LoginUserDTO;
import vn.org.bvpkh.bvpkh_gov.dtos.RegisterUserDTO;
import vn.org.bvpkh.bvpkh_gov.dtos.ResponseDto;
import vn.org.bvpkh.bvpkh_gov.services.IUserService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    private final IUserService userService;

    @RequestMapping("/login")
    public ResponseEntity<ResponseDto> login(@RequestBody LoginUserDTO loginUserDTO) {
        ResponseDto userDTO = userService.login(loginUserDTO);
        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @RequestMapping("/register")
    public ResponseEntity<ResponseDto> register(@RequestBody RegisterUserDTO registerUserDTO) {
        ResponseDto userDTO = userService.registerUser(registerUserDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
