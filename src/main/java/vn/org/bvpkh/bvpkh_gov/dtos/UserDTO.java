package vn.org.bvpkh.bvpkh_gov.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Builder
public class UserDTO {
    private String username;
    private String email;
    private List<String> roles;
    private String name;
    private String avatar;
    private String accessToken;
}
