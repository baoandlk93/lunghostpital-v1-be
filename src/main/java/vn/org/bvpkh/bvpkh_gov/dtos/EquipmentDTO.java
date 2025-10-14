package vn.org.bvpkh.bvpkh_gov.dtos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import vn.org.bvpkh.bvpkh_gov.utilities.enums.EStatus;
import vn.org.bvpkh.bvpkh_gov.utilities.enums.EStatusOfUse;

import java.io.Serializable;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EquipmentDTO implements Serializable {
    private String deviceCode;
    private String name;
    private String model;
    private String company;
    private int quantity;
    private String assetSource;
    private String yearOfSupply;
    private Double price;
    private String statusOfUse;
    private String status;
    private String timeIn;
    private String timeOut;
    private String timeUse;
    private int stock;
    private String classification;
    private String category;
    private String location;
    private String department;
    private String timeCheck;
    private String maintenance;
    private String image;
    private String note;
}
