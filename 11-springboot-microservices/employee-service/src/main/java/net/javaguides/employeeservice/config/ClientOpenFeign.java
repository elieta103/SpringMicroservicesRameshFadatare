package net.javaguides.employeeservice.config;


import net.javaguides.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")  // Configuracion sin eureka, sin load balancer
@FeignClient(name = "DEPARTMENT-SERVICE")  // Configuracion con eureka, con load balancer
public interface ClientOpenFeign {
    @GetMapping("/api/departments/{departmentCode}")
    DepartmentDto getDepartment(@PathVariable("departmentCode") String departmentCode);
}
