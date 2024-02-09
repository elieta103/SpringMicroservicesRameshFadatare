# 18  REST API Documentaction

- Adding springdoc-openapi Maven dependency
- Defining General API Information (Using Annotations)
- Customizing Swagger API Documentation with Annotations
- Customizing Swagger Models Documentation with Annotations

- http://localhost:8080/swagger-ui/index.html
- http://localhost:8080/v3/api-docs
- http://localhost:8081/swagger-ui/index.html
- http://localhost:8081/v3/api-docs
- http://localhost:8083/swagger-ui/index.html
- http://localhost:8083/v3/api-docs

## Para ejecutar todo :
- Iniciar FrontEnd
  - ...react-frontend>npm start
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
- GET  : http://localhost:9191/api/departments/message  http://localhost:8080/api/departments/message, ver cambios de actuator


- NOTA IMPORTANTE :
- CLIENT OPEN-FEIGN & MICROMETER, ZIPKIN.  
- PARA QUE FUNCIONEN LAS METRICAS CON ZIPKIN Y MICROMETER, SE DEBE USAR CLIENTES OPENFEIGN
- NO ES COMPATIBLE CON WEBCLIENT, SE AGREGO LA DEPENDENCIA (feign-micrometer)

