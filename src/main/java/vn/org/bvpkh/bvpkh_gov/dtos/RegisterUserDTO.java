package vn.org.bvpkh.bvpkh_gov.dtos;

import lombok.Data;

@Data
public class RegisterUserDTO {
    private String username;
    private String password;
    private String confirmPassword;
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private String role;
}
