package vn.org.bvpkh.bvpkh_gov.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginUserDTO implements Serializable {
    private String username;
    private String password;
}
