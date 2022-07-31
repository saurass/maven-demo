package ninja.codeplayer.springboot.demo.controller;

import ninja.codeplayer.springboot.demo.entity.Department;
import ninja.codeplayer.springboot.demo.error.DepartmentNotFoundException;
import ninja.codeplayer.springboot.demo.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("INSIDE saveDepartment DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department")
    public List<Department> getAllDepartments() {
        LOGGER.info("INSIDE get all departments list in DepartmentController");
        return departmentService.getAllDepartmentList();
    }

    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);

        return "Department Deleted";
    }

    @PutMapping("/department/{id}")
    public Department updateById(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateRecordById(departmentId, department);
    }

    @GetMapping("/department/code/{code}")
    public Department getByCode(@PathVariable("code") String departmentCode) {
        return departmentService.getByCode(departmentCode);
    }

}
