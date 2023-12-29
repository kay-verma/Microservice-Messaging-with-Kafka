package com.kay.apigateway.services;

import com.kay.apigateway.models.TransactionMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class KafkaProducerService {

    private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    KafkaTemplate<UUID, TransactionMessage> kafkaTemplate;
    public void send(String topicName, UUID key, TransactionMessage transactionMessage){
        var future = kafkaTemplate.send(topicName, key, transactionMessage);

        //whenComplete sets the callback when there is an exception making it async
        future.whenComplete((sendResult, exception) -> {
            if (exception != null){
                LOGGER.error(exception.getMessage());
                future.completeExceptionally(exception);
            }else {
                future.complete(sendResult);
            }
            LOGGER.info("This Id is: " + transactionMessage.getTransactionId()
                    + "transaction status to kafka topic:" + transactionMessage.getStatus());
                });
    }
}
