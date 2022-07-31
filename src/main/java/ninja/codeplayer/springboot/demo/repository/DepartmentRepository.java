package ninja.codeplayer.springboot.demo.repository;

import ninja.codeplayer.springboot.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public Department findByDepartmentCode(String departmentCode);
}
