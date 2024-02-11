FROM eclipse-temurin:17
VOLUME /tmp
EXPOSE 8761
ADD ./target/service-registry-0.0.1-SNAPSHOT.jar service-registry.jar
ENTRYPOINT ["java","-jar","/service-registry.jar"]