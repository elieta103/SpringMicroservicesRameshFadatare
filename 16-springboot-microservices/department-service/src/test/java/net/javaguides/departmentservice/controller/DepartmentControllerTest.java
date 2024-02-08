package net.javaguides.departmentservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    DepartmentService  departmentService;

    @Test
    void getDepartment() throws  Exception{
        DepartmentDto departmentDto = getValidDepartmentDto();
        given(departmentService.getDepartmentByCode(any())).willReturn(departmentDto);

        mockMvc.perform(get("/api/departments/MKT001").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.departmentCode").value("MKT001"));
    }

    @Test
    void saveDepartment() throws Exception {
        DepartmentDto departmentDto = getValidDepartmentDto();

        String departmentDtoJson = objectMapper.writeValueAsString(departmentDto);

        given(departmentService.saveDepartment(any())).willReturn(departmentDto);

        mockMvc.perform(post("/api/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(departmentDtoJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.departmentCode").value(departmentDto.getDepartmentCode()));
    }

    DepartmentDto getValidDepartmentDto(){
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("Marketing");
        departmentDto.setDepartmentDescription("Marketing Department");
        departmentDto.setDepartmentCode("MKT001");
        return departmentDto;
    }
}