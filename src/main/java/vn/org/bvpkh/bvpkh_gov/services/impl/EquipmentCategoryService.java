package vn.org.bvpkh.bvpkh_gov.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.org.bvpkh.bvpkh_gov.dtos.CategoryEquipmentDTO;
import vn.org.bvpkh.bvpkh_gov.entities.management_equipment.EquipmentCategory;
import vn.org.bvpkh.bvpkh_gov.repositories.IEquipmentCategoryRepository;
import vn.org.bvpkh.bvpkh_gov.services.IEquipmentCategoryService;
@Service
@AllArgsConstructor
public class EquipmentCategoryService implements IEquipmentCategoryService {
    private final IEquipmentCategoryRepository equipmentCategoryRepository;
    @Override
    public Page<EquipmentCategory> findAll(Pageable pageable) {
        return equipmentCategoryRepository.findAll(pageable);
    }

    @Override
    public Page<EquipmentCategory> findByName(String name, Pageable pageable) {
        return equipmentCategoryRepository.findAllByNameContains(name, pageable);
    }

    @Override
    public Page<EquipmentCategory> findByNameLike(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<EquipmentCategory> findByNameContaining(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Page<EquipmentCategory> findByNameContainingIgnoreCase(String name, Pageable pageable) {
        return null;
    }

    @Override
    public EquipmentCategory findById(Long id) {
        return null;
    }

    @Override
    public EquipmentCategory findByName(String name) {
        return null;
    }

    @Override
    public EquipmentCategory save(CategoryEquipmentDTO categoryEquipmentDTO) {
        EquipmentCategory equipmentCategory = new EquipmentCategory();
        equipmentCategory.setName(categoryEquipmentDTO.getName());
        equipmentCategory.setId(categoryEquipmentDTO.getId());
        return equipmentCategoryRepository.save(equipmentCategory);
    }

    @Override
    public void delete(EquipmentCategory equipmentCategory) {
        
    }
}
