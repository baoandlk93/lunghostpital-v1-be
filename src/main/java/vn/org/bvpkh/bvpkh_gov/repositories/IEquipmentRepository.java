package vn.org.bvpkh.bvpkh_gov.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.org.bvpkh.bvpkh_gov.dtos.EquipmentDTO;
import vn.org.bvpkh.bvpkh_gov.entities.management_equipment.Equipment;

public interface IEquipmentRepository extends JpaRepository<Equipment, Long> {
    Page<Equipment> findAllByNameContains(String name, Pageable  pageable);
}
