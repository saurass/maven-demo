package ninja.codeplayer.springboot.demo.service;

import ninja.codeplayer.springboot.demo.entity.Department;
import ninja.codeplayer.springboot.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentCode("IT")
                .departmentAddress("101 home address")
                .departmentName("Info tech")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentCode("IT"))
                .thenReturn(department);

    }

}