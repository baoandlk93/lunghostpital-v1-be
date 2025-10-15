package vn.org.bvpkh.bvpkh_gov.entities.management_equipment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.org.bvpkh.bvpkh_gov.entities.Department;
import vn.org.bvpkh.bvpkh_gov.utilities.enums.EClassification;
import vn.org.bvpkh.bvpkh_gov.utilities.enums.EStatus;
import vn.org.bvpkh.bvpkh_gov.utilities.enums.EStatusOfUse;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Equipment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String code;
    String name;
    String note;
    String model;
    String manufacturer;
    Long quantity;
    String assetSource;
    String yearOfSupply;
    String price;
    String maintenance;
    String image;
    EStatusOfUse statusOfUse;
    EStatus status;
    Date timeIn;
    Date timeOut;
    Date timeUse;
    Date timeCheck;
    Long stock;
    EClassification classification;
    @ManyToOne
    @JoinColumn(name = "equipment_category_id", referencedColumnName = "id")
    @JsonManagedReference
    EquipmentCategory equipmentCategory;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    @JsonManagedReference
    Warehouse warehouse;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "equipment_department",
            joinColumns = @JoinColumn(name = "equipment_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id")
    )
    Set<Department> department = new HashSet<>();


}
