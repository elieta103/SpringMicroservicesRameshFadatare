# 16 Add Organization Microservice to existing Project

- Create Organization-Service using Spring Boot
- Configure MySQL Database
- Create Organization JPA Entity and Spring Data JPA Repository
- Create OrganizationDto and OrganizationMapper
- Build Save Organization REST API
- Build Get Organization By Code REST API
- Make REST API Call from Employee-Service to Organization-Service
- Register Organization-Service as Eureka Client
- Refactor Organization-Service to use Config Service
- Configure Spring Cloud Bus
- Configure Routes for Organization-Service in API-Gateway
- Implement distributed tracing in Organization-Service

## Para ejecutar todo :
- Iniciar MySQL
- Run los services :
  - service-registry
  - config-service
  - api-gateway
  - organization-service
  - department-service
  - employee-service
  
- Run Zipkin
- docker run --rm -it --name zipkin -p 9411:9411 openzipkin/zipkin
- Run a Query
- http://localhost:9411/zipkin/

- Run Spring Cloud Bus
- docker pull rabbitmq
- docker run --rm -it -p 5672:5672 rabbitmq
- POST : http://localhost:8080/actuator/busrefresh  devuelve 204 NoContent


- NOTA IMPORTANTE :
- CLIENT OPEN-FEIGN & MICROMETER, ZIPKIN.  
- PARA QUE FUNCIONEN LAS METRICAS CON ZIPKIN Y MICROMETER, SE DEBE USAR CLIENTES OPENFEIGN
- NO ES COMPATIBLE CON WEBCLIENT, SE AGREGO LA DEPENDENCIA (feign-micrometer)

