# 11 Api Gateway using Spring Cloud Gateway


00. EndPoints
  - EmployeeService
    - http://localhost:9191/api/employees/1
  - DepartmentService
    - http://localhost:9191/api/departments/IT001
01. Crear Spring boot project api-gateway
  - Cuando se importa el servicio api-gateway, no se agrega como modulo al project padre, se debe agregar.
    - Seleccionar parent project 10-...
    - File->Project Structure-> (+) Import module(Buscar carpeta) ->Seleccionar pom.xml ,  
    - Tambien funciona :
    - File->Project Structure-> (+) Import module(Buscar carpeta)->OK->import module from external module-> maven -> Create
    - Una vez importado aparece un recuadro azul
02. Registrar api-gateway como Cliente de Eureka
    ## Update on Using Spring Boot 3 Version
    - In the next lecture, make the below small change to support Spring Boot 3 and Spring Cloud 2022.0.0:
    - Don’t annotate an entry-point DepartmentServiceApplication class with @EnableEurekaClient 
    - This annotation was removed in spring cloud 2022.0.0 and provided auto-configuration.
03. Configurar Routes y probar con Postman.
04. Los routes se pueden agregar en el properties y programaticamente



