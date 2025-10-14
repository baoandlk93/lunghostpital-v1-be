package vn.org.bvpkh.bvpkh_gov.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.org.bvpkh.bvpkh_gov.dtos.CategoryEquipmentDTO;
import vn.org.bvpkh.bvpkh_gov.entities.management_equipment.EquipmentCategory;

public interface IEquipmentCategoryService {
    Page<EquipmentCategory> findAll(Pageable pageable);
    Page<EquipmentCategory> findByName(String name, Pageable pageable);
    Page<EquipmentCategory> findByNameLike(String name, Pageable pageable);
    Page<EquipmentCategory> findByNameContaining(String name, Pageable pageable);
    Page<EquipmentCategory> findByNameContainingIgnoreCase(String name, Pageable pageable);
    EquipmentCategory findById(Long id);
    EquipmentCategory findByName(String name);
    EquipmentCategory save(CategoryEquipmentDTO categoryEquipmentDTO);
    void delete(EquipmentCategory equipmentCategory);
}
