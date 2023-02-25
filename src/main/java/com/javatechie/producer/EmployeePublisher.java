package com.javatechie.producer;

import com.javatechie.config.MessagingConfig;
import com.javatechie.dto.Employee;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EmployeePublisher {

    private RabbitTemplate template;


    public void publishEmployeeInfo(Employee employee){
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, employee);
    }
}
