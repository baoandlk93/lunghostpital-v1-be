package vn.org.bvpkh.bvpkh_gov.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.org.bvpkh.bvpkh_gov.dtos.EquipmentDTO;
import vn.org.bvpkh.bvpkh_gov.entities.Department;

public interface IEquipmentService {
//    Thêm mới vật tư
    EquipmentDTO save(EquipmentDTO equipmentDTO);
    EquipmentDTO update(EquipmentDTO equipmentDTO);
    void delete(EquipmentDTO equipmentDTO);
    Page<EquipmentDTO> search(EquipmentDTO equipmentDTO, Pageable pageable);
    EquipmentDTO findByName(String equipmentName);
}
