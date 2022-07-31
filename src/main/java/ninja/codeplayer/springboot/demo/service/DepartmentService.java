package ninja.codeplayer.springboot.demo.service;

import ninja.codeplayer.springboot.demo.entity.Department;
import ninja.codeplayer.springboot.demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> getAllDepartmentList();

    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateRecordById(Long departmentId, Department department);

    public Department getByCode(String departmentName);
}
