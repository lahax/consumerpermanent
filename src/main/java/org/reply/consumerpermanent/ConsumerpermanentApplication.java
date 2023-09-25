package org.reply.consumerpermanent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@EnableConfigurationProperties
public class ConsumerpermanentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerpermanentApplication.class, args);
	}

}
