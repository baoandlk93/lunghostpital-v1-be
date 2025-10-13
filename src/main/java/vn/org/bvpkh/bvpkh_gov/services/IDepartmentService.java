package vn.org.bvpkh.bvpkh_gov.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.org.bvpkh.bvpkh_gov.dtos.DepartmentDTO;
import vn.org.bvpkh.bvpkh_gov.entities.Department;

public interface IDepartmentService {
    Page<Department> findAll(String name, Pageable pageable);
    Department findById(Long id);
    Department save(DepartmentDTO departmentDTO);
    void delete(Department department);
}
