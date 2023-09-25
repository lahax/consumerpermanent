package org.reply.consumerpermanent;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = {"Event", "Diagnostics", "digic_event", "digic_diagnostics"}, groupId="json-consumer-permanent")
    public void readMessage(String message){
        System.out.println(message);
    }

}