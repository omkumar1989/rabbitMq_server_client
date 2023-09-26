package com.om.rabbitmq.comsumer.rabbitmqconsumer.user;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.om.rabbitmq.comsumer.rabbitmqconsumer.dto.OrderStatus;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class User {
    @Autowired
    ObjectMapper mapper;
    @RabbitListener(queues = "pro_queue")
    public void consumerMessageFromQueue(Message status) {
        /*System.out.println(new Jackson2JsonMessageConverter(String.valueOf(status)));*/
        System.out.println("Message Recieved from queus : " + status);

        OrderStatus st= null;
        try {
            st = mapper.readValue(new String(status.getBody()), OrderStatus.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("Message Recieved from queus : " + st.toString());
    }
}
