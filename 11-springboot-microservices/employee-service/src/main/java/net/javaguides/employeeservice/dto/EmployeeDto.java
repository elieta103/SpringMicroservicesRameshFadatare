package net.javaguides.employeeservice.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;

    @NotEmpty(message = "Primer nombre de empleado, no debe ser null o vacio :(")
    private String firstName;

    @NotEmpty(message = "Apellidos de empleado, no debe ser null o vacio :(")
    private String lastName;

    @NotEmpty(message = "Email de empleado, no debe ser null o vacio :(") // User email not should be null or empty
    @Email(message = "Email de empleado, formato no valido. :(")    // Format of email
    private String email;
}
