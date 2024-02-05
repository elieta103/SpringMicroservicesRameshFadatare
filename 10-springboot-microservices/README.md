# 09 Agregar Service Registry Eureka Netflix

00. EndPoints
  - EmployeeService
    - http://localhost:8081/api/employees/1
  - DepartmentService
    - http://localhost:8080/api/departments/IT001

01. Crear Spring boot project service-registry
  - Cuando se importa el servicio service-registry, no se agrega como modulo al project padre, se debe agregar.
    - Seleccionar parent project 10-springboot...
    - File->Project Structure-> (+) Import module(Buscar carpeta) ->Seleccionar pom.xml ,  
    - Tambien funciona :
    - File->Project Structure-> (+) Import module(Buscar carpeta)->OK->import module from external module-> maven -> Create
    - Una vez importado aparece un recuadro azul
02. Agregar @EnableEurekaServer
03. Deshabilitar Eureka Server como Eureka Client
04. Lanzar Eureka Server , Demo
05. Registrar Department-Service como cliente de Eureka (Agregar dependencia Eureka-Client & Spring Cloud)
   - eureka.instance.client.serverUrl.defaultZone=http://localhost:8761/eureka/
06. Lanzar Department-Service, Demo
07. Registrar Employee-Service como cliente de Eureka (Agregar dependencia Eureka-Client & Spring Cloud)
    - eureka.instance.client.serverUrl.defaultZone=http://localhost:8761/eureka/
08. Lanzar Employee-Service, Demo
09. Multiples instancias de Department-Service
    - Crear jar de Deparment-Service => mvn:package
    - .../department-service>java -jar -Dserver.port=8082 target/department-service-0.0.1-SNAPSHOT.jar
10. Spring Cloud Load Balancer incluido en la dependencia de Eureka

## Update on Using Spring Boot 3 Version
In the next lecture, make the below small change to support Spring Boot 3 and Spring Cloud 2022.0.0:

- Don’t annotate an entry-point DepartmentServiceApplication class with @EnableEurekaClient 
- This annotation was removed in spring cloud 2022.0.0 and provided auto-configuration.
- @EnableDiscoveryClient is optional