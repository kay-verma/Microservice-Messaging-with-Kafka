# Microservice Messaging with Kafka

This project showcases a fundamental Kafka architecture implemented with a producer and consumer in a microservices environment. It serves as a foundation for leveraging Kafka in event-driven communication.

## Key Features:

- **Docker Compose:** Easily spin up a local Kafka and Zookeeper cluster.
- **Producer (ApiGateway):** Publishes messages to a topic ("transaction-topic").
- **Consumer (ApiConsumer):** Listens for messages and logs them.

## Benefits:

- **Decoupled Microservices:** Services communicate asynchronously through events, enhancing independence and scalability.
- **Scalability:** Kafka efficiently handles high volumes of messages.
- **Fault Tolerance:** Messages are persisted, ensuring delivery even if services are unavailable.

## Getting Started:

1. **Clone the repository:**
    ```bash
    git clone https://github.com/kay-verma/Microservice-Messaging-with-Kafka.git
    ```

2. **Build and run Docker containers:**
    ```bash
    docker-compose up -d
    ```

3. **Postman screenshots:**
   ![postman](https://github.com/kay-verma/Microservice-Messaging-with-Kafka/blob/4c7970eecd4eff4dfd039d0c0c10bd444e5b3ebb/Screenshot%201.jpg)


4. **Run the producer (ApiGateway):**
![gateway](https://github.com/kay-verma/Microservice-Messaging-with-Kafka/blob/0a6320edfe5d35e72f17453033194b6a4009849f/Screenshot%203.jpg)
5. **Run the consumer (ApiConsumer):**
![consumer](https://github.com/kay-verma/Microservice-Messaging-with-Kafka/blob/0a6320edfe5d35e72f17453033194b6a4009849f/Screenshot%202.jpg)
## Further Development:

- Extend the consumer to perform actions based on message content (e.g., send emails, update databases).
- Implement complex workflows by chaining messages to other topics.
- Integrate with your existing microservices to enable event-driven communication.
