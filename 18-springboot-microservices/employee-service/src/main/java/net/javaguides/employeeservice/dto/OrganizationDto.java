package net.javaguides.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {
    private Long id;
    @Schema(
            description = "Nombre de organizacion"
    )
    private String organizationName;

    @Schema(
            description = "Descripcion de organizacion"
    )
    private String organizationDescription;

    @Schema(
            description = "Codigo de organizacion"
    )
    private String organizationCode;

    @Schema(
            description = "Fecha de creacion"
    )
    private LocalDateTime createdDate;
}
