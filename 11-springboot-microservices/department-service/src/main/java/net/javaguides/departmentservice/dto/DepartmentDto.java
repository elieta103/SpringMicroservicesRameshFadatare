package net.javaguides.departmentservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private Long id;

    @NotEmpty(message = "Nombre de departamento, no debe ser null o vacio :(")
    private String departmentName;

    @NotEmpty(message = "Descripcion de departamento, no debe ser null o vacio :(")
    private String departmentDescription;

    @NotEmpty(message = "Codigo de departamento, no debe ser null o vacio :(")
    private String departmentCode;
}