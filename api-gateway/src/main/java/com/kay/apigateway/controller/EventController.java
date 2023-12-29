package com.kay.apigateway.controller;

import com.kay.apigateway.models.TransactionMessage;
import com.kay.apigateway.services.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class EventController {
    @Autowired
    KafkaProducerService kafkaProducerService;

    @PostMapping("/event")
    ResponseEntity<String> event(@RequestBody TransactionMessage transactionMessage){
        UUID uuid = UUID.randomUUID();
        log.info("We received a key with transaction id" + uuid);
        kafkaProducerService.send("transaction-topic",uuid, transactionMessage);

        return ResponseEntity.ok("Sent");
    }


}
