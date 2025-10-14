package vn.org.bvpkh.bvpkh_gov.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CategoryEquipmentDTO implements Serializable {
    private String name;
    private Long id;

}
