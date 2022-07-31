package ninja.codeplayer.springboot.demo.service;

import ninja.codeplayer.springboot.demo.entity.Department;
import ninja.codeplayer.springboot.demo.error.DepartmentNotFoundException;
import ninja.codeplayer.springboot.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent())
            throw new DepartmentNotFoundException("Department Not Found");

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateRecordById(Long departmentId, Department department) {
        Department departmentObj = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && ! "".equalsIgnoreCase(department.getDepartmentName()))
            departmentObj.setDepartmentName(department.getDepartmentName());
        if(Objects.nonNull(department.getDepartmentAddress()) && ! "".equalsIgnoreCase(department.getDepartmentAddress()))
            departmentObj.setDepartmentAddress(department.getDepartmentAddress());
        if(Objects.nonNull(department.getDepartmentCode()) && ! "".equalsIgnoreCase(department.getDepartmentCode()))
            departmentObj.setDepartmentCode(department.getDepartmentCode());

        return departmentRepository.save(departmentObj);
    }

    @Override
    public Department getByCode(String departmentName) {
        return departmentRepository.findByDepartmentCode(departmentName);
    }


}
