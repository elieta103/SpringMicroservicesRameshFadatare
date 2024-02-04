package net.javaguides.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    // User first name not should be null or empty
    @NotEmpty(message = "User first name, no debe ser null o vacio :(")
    private String firstName;

    // User last name not should be null or empty
    @NotEmpty(message = "User last name, no debe ser null o vacio :(")
    private String lastName;

    @NotEmpty(message = "User Email, no debe ser null o vacio :(") // User email not should be null or empty
    @Email(message = "User Email, formato no valido. :(")    // Format of email
    private String email;
}
