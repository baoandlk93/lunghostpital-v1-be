package vn.org.bvpkh.bvpkh_gov.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class RoleDTO implements Serializable {
    private Long id;
    private String name;
    private String description;
}
