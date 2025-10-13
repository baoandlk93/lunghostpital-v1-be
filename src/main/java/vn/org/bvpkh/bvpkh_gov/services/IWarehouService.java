package vn.org.bvpkh.bvpkh_gov.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.org.bvpkh.bvpkh_gov.dtos.WarehouseDTO;
import vn.org.bvpkh.bvpkh_gov.entities.management_equipment.Warehouse;

public interface IWarehouService {
    Page<Warehouse> findAll(Pageable pageable);
    Warehouse findOne(Long id);
    Warehouse save(WarehouseDTO warehouseDTO);
    Warehouse update(Warehouse warehouse);
    void delete(Long id);
}
