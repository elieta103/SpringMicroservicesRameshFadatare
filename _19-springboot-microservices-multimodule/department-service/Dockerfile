FROM eclipse-temurin:17
VOLUME /tmp
EXPOSE 8080
ADD ./target/department-service-0.0.1-SNAPSHOT.jar department-service.jar
ENTRYPOINT ["java","-jar","/department-service.jar"]