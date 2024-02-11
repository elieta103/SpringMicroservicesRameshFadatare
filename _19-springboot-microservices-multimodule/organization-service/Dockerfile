FROM eclipse-temurin:17
VOLUME /tmp
EXPOSE 8083
ADD ./target/organization-service-0.0.1-SNAPSHOT.jar organization-service.jar
ENTRYPOINT ["java","-jar","/organization-service.jar"]