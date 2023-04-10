package com.javapoint.habits.Receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(Mail message) {
        message.setMessage("Hello, user! This is a reminder for you to practice your habits: "); //add user_id and habits
        System.out.println(message);
    }

}
