FROM eclipse-temurin:17
VOLUME /tmp
EXPOSE 9191
ADD ./target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar
ENTRYPOINT ["java","-jar","/api-gateway.jar"]