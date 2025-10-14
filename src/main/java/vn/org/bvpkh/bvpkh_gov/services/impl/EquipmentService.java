package vn.org.bvpkh.bvpkh_gov.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.org.bvpkh.bvpkh_gov.dtos.EquipmentDTO;
import vn.org.bvpkh.bvpkh_gov.repositories.IEquipmentCategoryRepository;
import vn.org.bvpkh.bvpkh_gov.services.IEquipmentService;
@Service
@AllArgsConstructor
public class EquipmentService implements IEquipmentService {
    private final IEquipmentCategoryRepository equipmentCategoryRepository;

    @Override
    public EquipmentDTO save(EquipmentDTO equipmentDTO) {
        return null;
    }

    @Override
    public EquipmentDTO update(EquipmentDTO equipmentDTO) {
        return null;
    }

    @Override
    public void delete(EquipmentDTO equipmentDTO) {

    }

    @Override
    public Page<EquipmentDTO> search(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public EquipmentDTO findByName(String equipmentName) {
        return null;
    }
}
