package vn.org.bvpkh.bvpkh_gov.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentDTO {
    private String name;
    private Long id;
    private String description;
}
