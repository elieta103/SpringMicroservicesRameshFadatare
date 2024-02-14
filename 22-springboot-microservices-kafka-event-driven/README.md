# 21 Event Driven Kafka

### Base de datos y Topico
- docker-compose up
- docker exec --interactive --tty kafka1  kafka-console-consumer --topic order_topics --from-beginning --bootstrap-server localhost:19092


### Producer
- OrderService es el productor
- POST http://localhost:8080/api/v1/orders


### Consumer 
- EmailService, StockService son los consumidores