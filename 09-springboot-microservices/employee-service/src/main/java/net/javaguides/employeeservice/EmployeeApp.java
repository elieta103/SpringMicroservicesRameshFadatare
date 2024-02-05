package net.javaguides.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeApp {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApp.class, args);
	}

}
