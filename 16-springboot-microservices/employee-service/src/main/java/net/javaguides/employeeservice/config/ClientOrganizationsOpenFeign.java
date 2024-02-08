package net.javaguides.employeeservice.config;


import net.javaguides.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8083", value = "ORGANIZATION-SERVICE")  // Configuracion sin eureka, sin load balancer
@FeignClient(name = "ORGANIZATION-SERVICE")  // Configuracion con eureka, con load balancer
public interface ClientOrganizationsOpenFeign {
    @GetMapping("/api/organizations/{organizationCode}")
    OrganizationDto getOrganization(@PathVariable("organizationCode") String organizationCode);
}
