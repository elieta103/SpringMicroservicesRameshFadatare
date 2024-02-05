# 09 RestTemplate, WebClient, Spring Cloud Open Feign

- EmployeeService
  - http://localhost:8081/api/employees/1
- DepartmentService
  - http://localhost:8080/api/departments/IT001
- RestTemplate en mantenimiento, proximo a deprecated.
- WebClient es parte de webflux, permite llamadas sincronas, asincronas y de stream
- Spring Cloud Open Feign es declarativa, hace implementacion dinamica con JAX-RS 
  se hace por medio de la interfaces y anotaciones, 
  - Activar la anotacion en el main @EnableFeignClients
  - Agregar @FeignClient en la interfaz.
  - Se debe agregar la dependencia de Spring Cloud.