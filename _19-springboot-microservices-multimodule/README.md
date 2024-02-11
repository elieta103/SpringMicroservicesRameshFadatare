# 19 Docker Spring Boot Application & MultiModule


### Root Module
- In IntelliJ IDEA’s welcome dialog, click New Project. Choose Maven and click Next:
- Enter project name and specify artifact coordinates information as below:
- Click Finish. It will create a simple Maven project.

### SubModules
- Right-click on the root project, and select New > Module:
- Then enter the module name as SharedLibrary. Note that the parent module is CompanyProject:
- From pom.xml of submodules :
  - name       : department-service
  - GroupId    : net.javaguides
  - ArtifactId : department-service
  - Create, IntelliJ IDEA will create the  project under RootProject.
  - You can notice the pom.xml file of the root project was updated
- Copy & Paste, submodule if exists code.
- From Maven options , Click + (Add maven projects)
  - You can select maven options : clean , package ...
  - If you get an error
  ```Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.```
  - Fix errors of unit test
  - An alternative is skip Tests, add plugin
  ```
  <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <configuration>
      <skipTests>true</skipTests>
    </configuration>
  </plugin>
  ```
- When you execute maven task package, you will see 
  ```
  [INFO] Reactor Summary:
  [INFO]
  [INFO] api-gateway 0.0.1-SNAPSHOT ......................... SUCCESS [ 20.553 s]
  [INFO] config-server 0.0.1-SNAPSHOT ....................... SUCCESS [ 18.430 s]
  [INFO] department-service 0.0.1-SNAPSHOT .................. SUCCESS [ 12.427 s]
  [INFO] employee-service 0.0.1-SNAPSHOT .................... SUCCESS [ 11.599 s]
  [INFO] organization-service 0.0.1-SNAPSHOT ................ SUCCESS [  1.474 s]
  [INFO] service-registry 0.0.1-SNAPSHOT .................... SUCCESS [ 14.673 s]
  [INFO] _19-springboot-microservices-multimodule 1.0-SNAPSHOT SUCCESS [  0.002 s]
  ```

### Dockerfile 
- Cada project tiene su Dockerfile
- Desde la carpeta de cada project, el . hace referencia a la carpeta actual del proyecto.
- Se generan las imagenes

- docker build -t react-frontend:v1 .
- docker build -t service-registry:v1 .
- docker build -t config-server:v1 .
- docker build -t api-gateway:v1 .
- docker build -t employee-service:v1 .
- docker build -t department-service:v1 .
- docker build -t organization-service:v1 .


- docker run -dp 3000:3000 --name react-frontend react-frontend:v1
- docker run -dp 8888:8888 --name config-server config-server:v1
- docker run -dp 8761:8761 --name service-registry service-registry:v1

- Este paso de generar los container uno por uno, queda solucionado con :
```
    build:
      context: ./service-registry
      dockerfile: Dockerfile
```
- Se agrega las rutas de cada Dockerfile, solo es necesario :
  - docker-compose up


### Docker Compose
- Queda pendiente la Dockerizacion de Micrometer & Zipkin
- Credenciales Docker : id gresshel, mail gresshel@gmail.com, pwd elieta103
- Desde la raiz del proyecto : ...\_19-springboot-microservices-multimodule>
- docker-compose up







- Adding springdoc-openapi Maven dependency
- Defining General API Information (Using Annotations)
- Customizing Swagger API Documentation with Annotations
- Customizing Swagger Models Documentation with Annotations

- http://localhost:8080/swagger-ui/index.html
- http://localhost:8080/v3/api-docs
- http://localhost:8081/swagger-ui/index.html
- http://localhost:8081/v3/api-docs
- http://localhost:8083/swagger-ui/index.html
- http://localhost:8083/v3/api-docs

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

