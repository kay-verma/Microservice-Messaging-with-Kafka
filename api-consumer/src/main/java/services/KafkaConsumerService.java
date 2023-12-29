package services;

import com.kay.apiconsumer.models.TransactionMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumerService {
    @KafkaListener(topics = {"transaction-topic"}, groupId = "group-id")

        public void consume(TransactionMessage transactionMessage){
        log.info("received with the transaction ID"
                + transactionMessage.getTransactionId() +
                " The status is " + transactionMessage.getStatus()

        );
    }
}
