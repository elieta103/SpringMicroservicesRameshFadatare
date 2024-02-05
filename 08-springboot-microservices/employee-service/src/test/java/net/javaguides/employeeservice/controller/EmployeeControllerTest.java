package net.javaguides.employeeservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    EmployeeService  employeeService;

    @Test
    void getEmployee() throws  Exception{
        EmployeeDto employeeDto = getValidDepartmentDto();
        given(employeeService.getEmployeeById(any())).willReturn(employeeDto);

        mockMvc.perform(get("/api/employees/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("Eliel"));
    }

    @Test
    void saveEmployee() throws Exception {
        EmployeeDto employeeDto = getValidDepartmentDto();

        String employeeDtoJson = objectMapper.writeValueAsString(employeeDto);

        given(employeeService.saveEmployee(any())).willReturn(employeeDto);

        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeDtoJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value(employeeDto.getFirstName()));
    }

    EmployeeDto getValidDepartmentDto(){
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("Eliel");
        employeeDto.setLastName("Herrera");
        employeeDto.setEmail("gressheliel@gmail.com");

        return employeeDto;
    }
}