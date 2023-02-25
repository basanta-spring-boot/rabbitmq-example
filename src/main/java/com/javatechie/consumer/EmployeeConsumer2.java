package com.javatechie.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.config.MessagingConfig;
import com.javatechie.dto.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConsumer2 {

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeEmployeeEvents(Employee employee) {
        try {
            System.out.println("Consumer 2 received an event :  " + new ObjectMapper().writeValueAsString(employee));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
