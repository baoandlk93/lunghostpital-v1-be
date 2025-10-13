package vn.org.bvpkh.bvpkh_gov.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.org.bvpkh.bvpkh_gov.entities.Department;
import vn.org.bvpkh.bvpkh_gov.repositories.IDepartmentRepository;
import vn.org.bvpkh.bvpkh_gov.services.IDepartmentService;

@Service
@AllArgsConstructor
public class DepartmentService implements IDepartmentService {
    private final IDepartmentRepository departmentRepository;

    @Override
    public Page<Department> findAll(String name, Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void delete(Department department) {
        departmentRepository.delete(department);
    }
}
