# 20 Simple Kafka application 

### Kafka con la Aplicacion
- STEP 1: DOWNLOAD AND INSTALL KAFKA
  - https://dlcdn.apache.org/kafka/3.2.0/kafka_2.13-3.2.0.tgz

- STEP 2: START THE KAFKA ENVIRONMENT
  - Start the ZooKeeper service
  - C:\Users\RAMESH\Downloads\kafka>.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

- Start the Kafka broker service
  - C:\Users\RAMESH\Downloads\kafka>.\bin\windows\kafka-server-start.bat .\config\server.properties

- STEP 3: CREATE A TOPIC TO STORE YOUR EVENTS
  - C:\Users\RAMESH\Downloads\kafka>.\bin\windows\kafka-topics.bat --create --topic topic_demo --bootstrap-server localhost:9092

- STEP 4: WRITE SOME EVENTS INTO THE TOPIC
  - C:\Users\RAMESH\Downloads\kafka>.\bin\windows\kafka-console-producer.bat --topic topic_demo --bootstrap-server localhost:9092
  - >hello world
  - >topic demo

- STEP 5:  READ THE EVENTS
  - C:\Users\RAMESH\Downloads\kafka>.\bin\windows\kafka-console-consumer.bat --topic topic_demo --from-beginning --bootstrap-server localhost:9092
  - hello world
  - topic demo


### KAFKA CON DOCKER
- INICIAR IMAGEN Y CONTAINER
  - docker-compose up

- ENTRAR AL CONTAINER :
  - docker exec -it kafka1 bash

- CREAR UN TOPICO
  - kafka-topics --bootstrap-server kafka1:19092 --create --topic topic_demo --replication-factor 1 --partitions 1

- CONSOLA PRODUCTOR
  - docker exec --interactive --tty kafka1  kafka-console-producer --bootstrap-server kafka1:19092 --topic topic_demo
  - >hello world
  - >topic demo

- CONSOLA CONSUMIDOR
  - docker exec --interactive --tty kafka1  kafka-console-consumer --bootstrap-server kafka1:19092 --topic topic_demo --from-beginning
  - hello world
  - topic demo

- LEER MENSAJES DESDE UN TOPICO CREADO CON SPRING BOOT (javaguides)
  - docker exec --interactive --tty kafka1  kafka-console-consumer --topic javaguides --from-beginning --bootstrap-server localhost:19092
  - docker exec --interactive --tty kafka1  kafka-console-consumer --topic javaguides_json --from-beginning --bootstrap-server localhost:19092


