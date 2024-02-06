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