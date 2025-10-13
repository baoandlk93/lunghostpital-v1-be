package vn.org.bvpkh.bvpkh_gov.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.org.bvpkh.bvpkh_gov.entities.management_equipment.Warehouse;

public interface IWarehouseRepository extends JpaRepository<Warehouse,Long> {
}
