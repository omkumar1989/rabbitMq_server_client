package com.om.rabbit.rabbitmqpoc.publisher;

import com.om.rabbit.rabbitmqpoc.config.MessagingConfig;
import com.om.rabbit.rabbitmqpoc.dto.Order;
import com.om.rabbit.rabbitmqpoc.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{resturentName}")
    public String bookOrdr(@RequestBody Order order, @PathVariable String resturentName){
        order.setOrderId(UUID.randomUUID().toString());
        //resturant service call or any service
        //payment servic
        OrderStatus status=new OrderStatus(order,"PROCESS","order placed successfully in " +resturentName);
        template.convertAndSend(MessagingConfig.EXCHANGE,MessagingConfig.ROUTINGKEY,status);
        return "Success";
    }
}
