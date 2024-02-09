# 17 Simple FrontEnd with React

## Create React App using Create React App Tool
  - npx create-react-app react-frontend
  - cd react-frontend
  - npm start
- Adding Bootstrap in React Using NPM
  - npm i bootstrap --save
- Connecting React App with API-Gateway (REST API Call)
  - npm i axios --save
- Develop a React Component to Display User, Department & Organizations Details.
- Run React App and Demo


## Cors en ApiGateway
spring.cloud.gateway.globalcors.corsConfigurations.[/**].allowedOrigins=*
spring.cloud.gateway.globalcors.corsConfigurations.[/**].allowedMethods=GET,POST,PUT,DELETE

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

