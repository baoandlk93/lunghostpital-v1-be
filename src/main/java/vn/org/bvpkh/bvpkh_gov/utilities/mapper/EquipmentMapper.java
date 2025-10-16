package vn.org.bvpkh.bvpkh_gov.utilities.mapper;

import org.springframework.data.domain.Page;
import vn.org.bvpkh.bvpkh_gov.dtos.EquipmentDTO;
import vn.org.bvpkh.bvpkh_gov.entities.Department;
import vn.org.bvpkh.bvpkh_gov.entities.management_equipment.Equipment;

import java.util.List;
import java.util.stream.Collectors;

public class EquipmentMapper {
    public static EquipmentDTO toDTO(Equipment equipment) {
        return EquipmentDTO.builder()
                .id(equipment.getId())
                .deviceCode(equipment.getCode())
                .name(equipment.getName())
                .model(equipment.getModel())
                .manufacturer(equipment.getManufacturer())
                .quantity(equipment.getQuantity())
                .assetSource(equipment.getAssetSource())
                .yearOfSupply(equipment.getYearOfSupply())
                .price(equipment.getPrice())
                .statusOfUse(equipment.getStatusOfUse() != null ? equipment.getStatusOfUse().name() : null)
                .status(equipment.getStatus() != null ? equipment.getStatus().name() : null)
                .timeIn(equipment.getTimeIn())
                .timeOut(equipment.getTimeOut())
                .timeUse(equipment.getTimeUse())
                .timeCheck(equipment.getTimeCheck())
                .stock(equipment.getStock())
                .classification(equipment.getClassification() != null ? equipment.getClassification().name() : null)
                .category(equipment.getEquipmentCategory() != null ? equipment.getEquipmentCategory().getName() : null)
                .warehouse(equipment.getWarehouse() != null ? equipment.getWarehouse().getName() : null)
                .department(equipment.getDepartment().stream().map(Department::getName).collect(Collectors.joining(", ")))
                .maintenance(equipment.getMaintenance())
                .image(equipment.getImage())
                .note(equipment.getNote())
                .build();
    }

    public static List<EquipmentDTO> toDTOList(List<Equipment> equipmentList) {
        return equipmentList.stream().map(EquipmentMapper::toDTO).collect(Collectors.toList());
    }
    public static Page<EquipmentDTO> toDTOPages(Page<Equipment> equipmentPage) {
        return equipmentPage.map(EquipmentMapper::toDTO);
    }
}
