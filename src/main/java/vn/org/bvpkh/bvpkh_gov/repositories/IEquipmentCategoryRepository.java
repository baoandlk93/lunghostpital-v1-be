package vn.org.bvpkh.bvpkh_gov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.org.bvpkh.bvpkh_gov.entities.management_equipment.EquipmentCategory;

public interface IEquipmentCategoryRepository extends JpaRepository<EquipmentCategory,Long> {
}
