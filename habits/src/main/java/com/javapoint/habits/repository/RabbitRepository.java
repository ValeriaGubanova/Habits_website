package com.javapoint.habits.repository;

import com.javapoint.habits.model.Habits;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RabbitRepository {

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    @Value("${rabbitmq.queue}")
    private String queue;

//Exchange
    RabbitRepository rabbitTemplate = new RabbitRepository();
    rabbitTemplate.setQueueName("habit-alert");
    rabbitTemplate.setExchange("habits.Topic");

    //@Override
    public void send() {
        HabitsRepository habitsRepository = new HabitsRepository();
        ClientRepository client = new ClientRepository();
        List<Habits> habits = (List<Habits>) this.habitsRepository.findAll();
        for (Habits habit : habits) {
            String messageBody = "Hi " + client.getById(habit.getUId()) + ", it is time to work on your habits: " + habit.getDesc();
            rabbitTemplate.convertAndSend("habit-alert", messageBody);
        }
    }
}
