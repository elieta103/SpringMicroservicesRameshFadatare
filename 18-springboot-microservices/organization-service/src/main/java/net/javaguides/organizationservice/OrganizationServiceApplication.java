package net.javaguides.organizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Rest API Documentation Organizations",
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
				description = "Spring Boot Rest API Organizations Management Documentation",
				url = "http://www.eliel.com/management"
		)
)

@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
