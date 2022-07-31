package ninja.codeplayer.springboot.demo.repository;

import ninja.codeplayer.springboot.demo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentCode("IT")
                .departmentAddress("101 home address")
                .departmentName("Info tech")
                .build();
        testEntityManager.persist(department);
    }

    @Test
    public void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findByDepartmentCode("IT");
        assertEquals(department.getDepartmentCode(), "IT");
    }

}