package ninja.codeplayer.springboot.demo.controller;

import ninja.codeplayer.springboot.demo.entity.Department;
import ninja.codeplayer.springboot.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("Info tech")
                .departmentCode("IT")
                .departmentAddress("107 home town")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department InpDepartment = Department.builder()
                .departmentName("Info tech")
                .departmentCode("IT")
                .departmentAddress("107 home town")
                .departmentId(1L)
                .build();
        Mockito.when(departmentService.saveDepartment(InpDepartment))
                .thenReturn(department);
        mockMvc.perform(post("/department")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentName\": \"Computer Science\",\n" +
                        "    \"departmentAddress\": \"104 village address\",\n" +
                        "    \"departmentCode\": \"CSE\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    void deleteDepartmentById() {
    }
}