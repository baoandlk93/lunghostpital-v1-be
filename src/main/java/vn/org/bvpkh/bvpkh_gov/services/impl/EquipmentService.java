package vn.org.bvpkh.bvpkh_gov.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.org.bvpkh.bvpkh_gov.dtos.EquipmentDTO;
import vn.org.bvpkh.bvpkh_gov.entities.Department;
import vn.org.bvpkh.bvpkh_gov.entities.management_equipment.Equipment;
import vn.org.bvpkh.bvpkh_gov.entities.management_equipment.EquipmentCategory;
import vn.org.bvpkh.bvpkh_gov.entities.management_equipment.Warehouse;
import vn.org.bvpkh.bvpkh_gov.repositories.IDepartmentRepository;
import vn.org.bvpkh.bvpkh_gov.repositories.IEquipmentCategoryRepository;
import vn.org.bvpkh.bvpkh_gov.repositories.IEquipmentRepository;
import vn.org.bvpkh.bvpkh_gov.repositories.IWarehouseRepository;
import vn.org.bvpkh.bvpkh_gov.services.IEquipmentService;
import vn.org.bvpkh.bvpkh_gov.utilities.enums.EClassification;
import vn.org.bvpkh.bvpkh_gov.utilities.enums.EStatus;
import vn.org.bvpkh.bvpkh_gov.utilities.enums.EStatusOfUse;
import vn.org.bvpkh.bvpkh_gov.utilities.mapper.EquipmentMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EquipmentService implements IEquipmentService {
    private final IEquipmentCategoryRepository equipmentCategoryRepository;
    private final IEquipmentRepository equipmentRepository;
    private final IWarehouseRepository warehouseRepository;
    private final IDepartmentRepository departmentRepository;


    @Override
    public EquipmentDTO save(EquipmentDTO equipmentDTO) {
        Equipment equipment = new Equipment();

        // Chuyển đổi từ DTO sang Entity
        equipment.setCode(equipmentDTO.getDeviceCode());
        equipment.setName(equipmentDTO.getName());
        equipment.setModel(equipmentDTO.getModel());
        equipment.setManufacturer(equipmentDTO.getManufacturer());
        equipment.setQuantity(equipmentDTO.getQuantity());
        equipment.setAssetSource(equipmentDTO.getAssetSource());
        equipment.setYearOfSupply(equipmentDTO.getYearOfSupply());
        equipment.setPrice(equipmentDTO.getPrice());
        equipment.setMaintenance(equipmentDTO.getMaintenance());
        equipment.setImage(equipmentDTO.getImage());
        equipment.setNote(equipmentDTO.getNote());
        equipment.setStatusOfUse(EStatusOfUse.valueOf(equipmentDTO.getStatusOfUse()));
        equipment.setStatus(EStatus.valueOf(equipmentDTO.getStatus()));
        equipment.setTimeIn(equipmentDTO.getTimeIn());
        equipment.setTimeOut(equipmentDTO.getTimeOut());
        equipment.setTimeUse(equipmentDTO.getTimeUse());
        equipment.setTimeCheck(equipmentDTO.getTimeCheck());
        equipment.setStock(equipmentDTO.getStock());
        equipment.setClassification(EClassification.valueOf(equipmentDTO.getClassification()));

        // Xử lý EquipmentCategory
        if (equipmentDTO.getCategory() != null) {
            EquipmentCategory category = equipmentCategoryRepository.findByName(equipmentDTO.getCategory());
            equipment.setEquipmentCategory(category);
        }

        // Xử lý Warehouse
        if (equipmentDTO.getWarehouse() != null) {
            Warehouse warehouse = warehouseRepository.findByName(equipmentDTO.getWarehouse());
            equipment.setWarehouse(warehouse);
        }

        // Xử lý Departments
        if (equipmentDTO.getDepartment() != null) {
            Set<Department> departments = new HashSet<>();
            for (String deptName : equipmentDTO.getDepartment().split(",")) {
                Department department = departmentRepository.findByName(deptName.trim());
                if (department != null) {
                    departments.add(department);
                }
            }
            equipment.setDepartment(departments);
        }

        // Lưu Equipment
        Equipment savedEquipment = equipmentRepository.save(equipment);

        // Chuyển đổi lại thành DTO để trả về
        return EquipmentMapper.toDTO(savedEquipment);
    }

    @Override
    public EquipmentDTO update(EquipmentDTO equipmentDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {
        equipmentRepository.findById(id).ifPresent(equipmentRepository::delete);
    }

    @Override
    public Page<EquipmentDTO> search(String keyword, Pageable pageable) {
        Page<Equipment> equipmentPage = equipmentRepository.findAllByNameContains(keyword, pageable);
        List<EquipmentDTO> equipmentDTOList = EquipmentMapper.toDTOList(equipmentPage.getContent());
        return new PageImpl<>(equipmentDTOList, pageable, equipmentPage.getTotalElements());
    }

    @Override
    public EquipmentDTO findByName(String equipmentName) {
        return null;
    }
}
