# 24 Event-Driven RabbitMQ SpringBoot Application

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

  
### Microservices
- OrderService -> Publisher
- EmailService -> Consumer
- StockService -> Consumer

- Iniciar y enviar un mensaje desde OrderService, para que se creen los Queues
- Iniciar Email y Stock. Si se levantan antes de Order aparece que no está creada la Queue.


### Endpoints de envío de mensajes
- POST http://localhost:8080/api/v1/orders
  ```
  {  "name": ""  ,
     "qty": "",
     "price": ""
    }
  ```
