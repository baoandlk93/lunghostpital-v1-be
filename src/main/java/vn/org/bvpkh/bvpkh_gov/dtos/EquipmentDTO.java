package vn.org.bvpkh.bvpkh_gov.dtos;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import vn.org.bvpkh.bvpkh_gov.utilities.enums.EStatus;
import vn.org.bvpkh.bvpkh_gov.utilities.enums.EStatusOfUse;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EquipmentDTO implements Serializable {
    private String deviceCode;
    private String name;
    private String model;
    private String manufacturer;
    private Long quantity;
    private String assetSource;
    private String yearOfSupply;
    private String price;
    private String statusOfUse;
    private String status;
    private Date timeIn;
    private Date timeOut;
    private Date timeUse;
    private Date timeCheck;
    private Long stock;
    private String classification;
    private String category;
    private String warehouse;
    private String department;
    private String maintenance;
    private String image;
    private String note;
}
