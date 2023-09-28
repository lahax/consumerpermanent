package org.reply.consumerpermanent;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableKafka
@EnableConfigurationProperties
public class KafkaConsumerService {

    public static List<Message> messageList = new ArrayList<>();

    @KafkaListener(topics = {"Event", "Diagnostics", "digic_event", "digic_diagnostics"}, groupId="consumer-permanent")
    public void listen(ConsumerRecord<String, String> record){
        String topic = record.topic();
        String payload = record.value();
        String piattaforma = "Permanent";
        try {
            /*ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(value);
            String posId = jsonNode.get("posId").asText();
            String useCase = jsonNode.get("useCase").asText();
            String scopeId = jsonNode.get("scopeId").asText();
            String clientId = jsonNode.get("clientId").asText();
            JsonNode payload = jsonNode.get("payload");
            long receivedOn = jsonNode.get("receivedOn").asLong();
            JsonNode channel = jsonNode.get("channel");
            String posIdb = jsonNode.get("posId_B").toString();
            String posIda = jsonNode.get("posId_A").toString();
            JsonNode posGeo = jsonNode.get("posGeo");
            String account = jsonNode.get("account").toString();

            System.out.println("From platform: "+ groupId + " From topic: " + topic + " posId: " + posId + ", useCase: " + useCase + " scopeId: " + scopeId + " clientId: " + clientId + " payload: " + payload + " receivedOn: " + receivedOn + " channel: " + channel + " posId_B: " + posIdb + " posId_A: " + posIda + " posGeo: " + posGeo + " account: " + account);*/
            Message message = new Message(piattaforma, topic, payload);
            messageList.add(message);
            System.out.println(message.payload.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Message> getMessageList() {
        return messageList;
    }

    public void clearMessageList() throws InterruptedException {
        messageList.clear(); //svuotare lista dopo l'invio al Core
    }
}