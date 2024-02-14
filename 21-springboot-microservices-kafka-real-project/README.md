# 21 Kafka real application wikimedia , muiltimodule

- Crear app con spring.io
- Importar en IntelliJ
- Agregar en el pom.xml
  - <packaging>pom</packaging>
- Agregar muiltimodules
  - kafka-producer-wikimedia
  - kafka-consumer-database

- Agregar a los modulos soporte SpringBoot
```
@SpringBootApplication
public class SpringBootConsumerApplication  {
    public static void main(String[] args) {
       SpringApplication.run(SpringBootConsumerApplication.class);
    }
}
```
- Agregar a los modulos
  - <packaging>jar</packaging>

- Se puede eliminar la carpeta src/ del proyecto parent

### Base de datos y Topico
- docker-compose up
- docker exec --interactive --tty kafka1  kafka-console-consumer --topic wikimedia_recentchange --from-beginning --bootstrap-server localhost:19092


### Producer
- WikimediaChangesProducer (sendMessage()) se conecta al Stream, por medio de Event Handler, obtiene datos
- WikimediaChangesHandler (onMessage(String s, MessageEvent messageEvent)), envía datos del Stream al Topico
- Para iniciar la extraccion de datos del Stream y Envio al Topic, implementar CommandLineRunner
- Levantar la SpringBoot App
- Verificar el envío de los datos en el Topic : wikimedia_recentchange

### Consumer 
- Lee datos del Topico y los guarda en la Base de Datos