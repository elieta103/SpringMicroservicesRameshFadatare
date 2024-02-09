package net.javaguides.employeeservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "APIResponseDto Model Information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto{
    @Schema(
            description = "Empleado"
    )
    private EmployeeDto employeeDto;
    @Schema(
            description = "Departamento"
    )
    private DepartmentDto departmentDto;

    private OrganizationDto organizationDto;
}
