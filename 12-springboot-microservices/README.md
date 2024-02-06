# 12 Spring Cloud Config Server
00. EndPoints
  - EmployeeService
    - http://localhost:9191/api/employees/1
  - DepartmentService
    - http://localhost:9191/api/departments/IT001
01. Crear Spring boot project config-server
  - Cuando se importa el servicio config-server, no se agrega como modulo al project padre, se debe agregar.
    - Seleccionar parent project 11-...
    - File->Project Structure-> (+) Import module(Buscar carpeta) ->Seleccionar pom.xml ,  
    - Tambien funciona :
    - File->Project Structure-> (+) Import module(Buscar carpeta)->OK->import module from external module-> maven -> Create
    - Una vez importado aparece un recuadro azul
02. Habilitar servidor de configuracion : @EnableConfigServer 
03. Registrar config-server como Cliente de Eureka
    ## Update on Using Spring Boot 3 Version
    In the next lecture, make the below small change to support Spring Boot 3 and Spring Cloud 2022.0.0:
    - Don’t annotate an entry-point ConfigServerApplication class with @EnableEurekaClient 
    - This annotation was removed in spring cloud 2022.0.0 and provided auto-configuration.
04. Configurar config client server y actuator : en Employees y Departments
05. Los archivos de propiedades deben hacer match con el nombre de la aplicacion 
    - department-service.properties
    - employee-service.properties
06. Se debe omitir el nombre de la aplicacion en el archivo de properties del repo git, se deja en el properties local.
    - spring.application.name=EMPLOYEE-SERVICE
    - spring.application.name=DEPARTMENT-SERVICE
07. Activar servidor de configuracion
    - spring.config.import=optional:configserver:http://localhost:8888
08. Activar actuator en DepartmentService
    - management.endpoints.web.exposure.include=*
09. Al realizar algun cambio en las configuraciones 
    - Se debe reiniciar el servicio de config-server, no el servicio que tiene el cambio
    - Llamar : http://localhost:8080/actuator/refresh
    - Validar el cambio : http://localhost:8080/message


