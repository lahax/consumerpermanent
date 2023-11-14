package org.reply.consumerpermanent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    String piattaforma;
    String topic;
    String payload;
}
