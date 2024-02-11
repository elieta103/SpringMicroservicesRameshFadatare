package net.javaguides.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(
        description = "DepartmentDto Model Information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private  Long id;

    @Schema(
            description = "Nombre de departamento"
    )
    private String departmentName;

    @Schema(
            description = "Descripcion de departamento"
    )
    private String departmentDescription;

    @Schema(
            description = "Codigo de departamento"
    )
    private String departmentCode;
}
