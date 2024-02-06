# 13 Auto Refresh Config Changes using Spring Cloud Bus

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



