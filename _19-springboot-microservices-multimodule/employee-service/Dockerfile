FROM eclipse-temurin:17
VOLUME /tmp
EXPOSE 8081
ADD ./target/employee-service-0.0.1-SNAPSHOT.jar employee-service.jar
ENTRYPOINT ["java","-jar","/employee-service.jar"]