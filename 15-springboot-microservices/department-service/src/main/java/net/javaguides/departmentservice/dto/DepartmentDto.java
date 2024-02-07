package net.javaguides.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Schema(
     description = "DepartmentDto Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private Long id;

    @Schema(
            description = "Nombre de departamento"
    )
    @NotEmpty(message = "Nombre de departamento, no debe ser null o vacio :(")
    private String departmentName;

    @Schema(
            description = "Descripcion de departamento"
    )
    @NotEmpty(message = "Descripcion de departamento, no debe ser null o vacio :(")
    private String departmentDescription;

    @Schema(
            description = "Codigo de departamento"
    )
    @NotEmpty(message = "Codigo de departamento, no debe ser null o vacio :(")
    private String departmentCode;
}