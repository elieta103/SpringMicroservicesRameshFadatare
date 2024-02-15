# 21 Simple SpringBoot RabbitMQ Application

### Iniciar broker
- docker-compose up
- UI http://localhost:15672

### Crear y publicar un mensaje desde la UI
- Crear un exchanges (Permite rutear entrea varias Queue)
  - Exchanges 
  - Add a new exchanges 
    - Type :direct
    - Durability : Durable
    - Auto delete : NO
    - Internal : NO
    - Add exchange

  - Queues
  - Add a new queue
    - Name : queue_demo
    - Type: clasic
    - Durability : Durable
    - Auto delete : NO
    - Add queue

  - Exchanges
  - Click Bindings
    - Add binding from this exchange
    - To queue : queue_demo
    - Routing key : routing_key_demo
    - Click Bind

  - Publish Message
    - Routing Key : routing_key_demo
    - Payload : Hola Mundo

  - Get Message
    - Click en Queue Streams
    - Click en queue_demo
    - Get Messages -> Get Messages

### Spring Boot Autoconfiguration for Spring AMQP (RabbitMQ)
- Usadas por default no es necesario agregarlas en application.properties, si estan en localhost
```
spring.rabbitmq.host=localhost 
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```


### Configure RabbitMQ in SpringBoot
- RabbitMQConfig Class configura:
  - Queue(NombreQueue)         => Queue("javaguides")
  - TopicExchange(NombreTopic) => TopicExchange("javaguides_eexchange")
  - Binding(NombreBindingKey)  => Relacional Queue y TopicExchange con Rounting_key
  - Para cuando se envían JSON  se requiere :
    - @Bean public MessageConverter converter(){...}
    - @Bean public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){...}
  - Para cuando se envían String NO se requiere MessageConverter, ni AmqpTemplate.

- Objects configurados automaticamente por spring :
  - ConnectionFactory
  - RabbitTemplate
  - RabbitAdmin

  
### RabbitMQProducer, RabbitMQJsonProducer Produce a String Message && JSON Object
- Necesita el exchange y el rounting_key para decidir a que Queue, se envía el mensaje

### RabbitMQConsumer, RabbitMQJsonConsumer Consume a String Message && JSON Object
- Solo requiere el nombre del Queue

### Endpoints de envío de mensajes
- GET http://localhost:8080/api/v1/publish?message=hello
- POST http://localhost:8080/api/v1/publish
  ```
  { "id": "54",
    "firstName" : "Eliel",
    "lastName": "Herrera"
    }
  ```
