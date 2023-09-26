package com.om.rabbit.rabbitmqpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@EnableAutoConfiguration(exclude={org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration.class})*/
@SpringBootApplication

public class RabbitMqpocApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqpocApplication.class, args);
    }

}
