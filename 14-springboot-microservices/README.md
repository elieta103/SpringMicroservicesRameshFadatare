# 14 Distributed Tracing with Micrometer (alternative to Sleuth) and Zipkin

- Sleuth cannot be used with Spring Boot 3 because it is deprecated. 
  Therefore, I used Micrometer as an alternative.
- Please add the following dependencies to your microservices (department-service & employee-service)
  - micrometer-observation
  - micrometer-tracing-bridge-brave
  - zipkin-reporter-brave</artifactId>
  - feign-micrometer
  - micrometer-observation dependency will allow us to collect and report metrics from our application to Zipkin.
  - micrometer-tracing-bridge-brave dependency will allow us to trace our spring boot application.
  - zipkin-reporter-brave dependency allows us to send traces that we collect to Zipkin.
  - feign-micrometer dependency was added because I am using feign in my microservices to call other APIs. 
    This dependency will configure micrometer to work with feign.

- Start Zipkin as a docker container (be sure to have Docker running before you run the following command).
  - docker run --rm -it --name zipkin -p 9411:9411 openzipkin/zipkin


- Add Below properties to each Micro Service application.properties.
  - management.tracing.sampling.probability=1.0   
    Default value is 0.1 i.e mean only 10% of the REST Calls will be traced. 
    1.0 Will trace each REST Call and get a display.

  - logging.pattern.level=%5p [${spring.application.name:},%X{traceId:-},%X{spanId:-}]
    With this logging pattern the REST call Trace ID and Span ID will be known and can be searched on ZipKin web page.

  - logging.level.org.springframework.web=DEBUG  
    In depth logs are known, which are helpful for testing and debuging.

- Start http://127.0.0.1:9411/zipkin and run query


01. In order to reload the config changes in Config Client applications (department-service and employee-service),
    we need to trigger /refresh endpoint manually. This is not practical and viable if you have large number of applications.
02. Spring Cloud Bus module provides a solution.
03. Spring Cloud Bus module can be used to link multiple applications with a message broker and
    we can broadcast configuration changes.
    With acuator we need to call every service with the latest changes  : /refresh
    The solution is that every microservice subscribe to a broker, and when event is triggered
    the microservices will be informed about changes.

04. Add spring-cloud-starter-bus-amqp dependency to department-service and employee-service.
05. Install RabbitMQ using Docker.
    - docker pull rabbitmq
    - docker run --rm -it -p 5672:5672 rabbitmq
06. RabbitMQ configuration in application.properties of department-service and employee-service.
07. Create Simple REST API in employee-service & department-service.
08. Change department-service and employee-service properties file and call : /busrefresh
    Only one time !!
09. Department-Service Activate Actuator
    management.endpoints.web.exposure.include=*
09. Demo.
    - http://localhost:9191/api/employees/message
    - http://localhost:9191/api/departments/message
    - Modificar mensajes de los properties
    - Llamar a POST :http://localhost:8080/actuator/busrefresh
    - Validar cambios



