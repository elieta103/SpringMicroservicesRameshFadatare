package net.javaguides.employeeservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "EmployeeDto Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;

    @Schema(
            description = "Nombre de empleado"
    )
    @NotEmpty(message = "Primer nombre de empleado, no debe ser null o vacio :(")
    private String firstName;

    @Schema(
            description = "Apellidos e empleado"
    )
    @NotEmpty(message = "Apellidos de empleado, no debe ser null o vacio :(")
    private String lastName;

    @Schema(
            description = "Email de empleado"
    )
    @NotEmpty(message = "Email de empleado, no debe ser null o vacio :(") // User email not should be null or empty
    @Email(message = "Email de empleado, formato no valido. :(")    // Format of email
    private String email;

    private String organizationCode;
}
