package org.reply.consumerpermanent;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Message {
    String platform;
    String topic;
    String value; //il payload arrrivato senza nessuna normalizzazione
}
