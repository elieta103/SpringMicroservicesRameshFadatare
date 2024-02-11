package net.javaguides.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Rest API Documentation Employee",
				description = "Spring Boot Rest API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Eliel",
						email = "gresshel@gmail.com",
						url = "http://www.eliel.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.eliel.com/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot Rest API Employee Management Documentation",
				url = "http://www.eliel.com/management"
		)
)
public class EmployeeApp {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApp.class, args);
	}

}
