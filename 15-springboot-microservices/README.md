# 15 Circuit Breaker using Resilience4J Implementation

- How can implement a fallback method mechanism?
- How can implement a circuit breaker pattern?
- Can we implement a Retry mechanism?
- Can we implement Rate Limiter?

- Circuit breaker have 3 states
  - CLOSED : Will allow to flow all the request from one microservice ?
  - HALF OPEN : Mantain time limit, for example 5s, CB will remains 5s in open state and after that, it 
    will automatically move into half open state
  - OPEN : Mantain the threshold (limit), whenever service is calling department service and due
    to some reason a deparment service is down, for example make 5 request, 2 are success
    and 3 fail and set threshold=50%, then circuit breaker will move into open state.
    If fail rate exceded the treshold, then circuit breaker move into open state.


- Add dependencies
  - spring-cloud-starter-circuitbreaker-resilience4j
  - spring-boot-actuator
  - spring-boot-starter-aop

- Using @CircuitBreaker annotation to a method(it's calling to external service)
- Fallback method implementation
- Add Circuit Breaker configuration in application.properties
- Restart employee-service demo

- Actuator para : http://localhost:8081/actuator/health
- Levantar todos los servicios y validar que estén los circuitbreakers en "state": "CLOSED"
- Detener deparment-service.
  - Llamar: localhost:9191/api/employees/1 validar el fallbackMethod, y "state": "CLOSED"
  - Como minimumNumberOfCalls=5, entonces llamar deparment-service 2, 3, 4, 5
  - Llamar: localhost:9191/api/employees/1 ahora "state": "OPEN"
  - Como waitDurationInOpenState=5s, despues de 5s checar http://localhost:8081/actuator/health  "state": "HALF_OPEN"
  - Como permittedNumberOfCallsInHalfOpenState=3 hacer 3 llamadas y observar el cambio "state": "OPEN"
  - Levantar department-service hacer 3 llamadas OK
  - Llamar: localhost:9191/api/employees/1 ahora checar http://localhost:8081/actuator/health "state": "CLOSED"


# 15 Retry Pattern using Resilience4J Implementation
- Using @Retry annotation to a method (it is calling to external service)
- Fallback method implementation
- Add Retry config in application.properties
- Restart employee-service and demo