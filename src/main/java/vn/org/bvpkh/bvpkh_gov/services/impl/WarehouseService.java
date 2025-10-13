package vn.org.bvpkh.bvpkh_gov.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.org.bvpkh.bvpkh_gov.dtos.WarehouseDTO;
import vn.org.bvpkh.bvpkh_gov.entities.management_equipment.Warehouse;
import vn.org.bvpkh.bvpkh_gov.repositories.IWarehouseRepository;
import vn.org.bvpkh.bvpkh_gov.services.IWarehouService;

@Service
@AllArgsConstructor
public class WarehouseService implements IWarehouService {
    private final IWarehouseRepository warehouseRepository;

    @Override
    public Page<Warehouse> findAll(Pageable pageable) {
        Page<Warehouse> warehousePage = warehouseRepository.findAll(pageable);
        return warehousePage;
    }

    @Override
    public Warehouse findOne(Long id) {
        return null;
    }

    @Override
    public Warehouse save(WarehouseDTO warehouseDTO) {
        Warehouse warehouse = new Warehouse();
        warehouse.setName(warehouseDTO.getName());
        warehouse.setDescription(warehouseDTO.getDescription());
        warehouse.setId(warehouse.getId());
        return warehouseRepository.save(warehouse);
    }

    @Override
    public Warehouse update(Warehouse warehouse) {

        return warehouseRepository.save(warehouse);
    }

    @Override
    public void delete(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElse(null);
        assert warehouse != null;
        warehouseRepository.delete(warehouse);
    }
}
