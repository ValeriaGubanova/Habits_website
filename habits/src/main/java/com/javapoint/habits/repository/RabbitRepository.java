package com.javapoint.habits.repository;

import com.javapoint.habits.model.Habits;
import com.javapoint.habits.model.RabbitMQMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RabbitRepository {

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    @Value("${rabbitmq.queue}")
    private String queue;

//Exchange

    private final ClientRepository clientRepository;
    private final HabitsRepository habitsRepository;
    private final RabbitTemplate rabbitTemplate;

    public RabbitRepository(ClientRepository clientRepository, HabitsRepository habitsRepository, RabbitTemplate rabbitTemplate) {
        this.clientRepository = clientRepository;
        this.habitsRepository = habitsRepository;
        this.rabbitTemplate = rabbitTemplate;
    }
    //@Override
    public void send(RabbitMQMessage message) {
        List<Habits> habits = (List<Habits>) this.habitsRepository.findAll();
        for (Habits habit : habits) {
            rabbitTemplate.setQueue("habit-alert");
            rabbitTemplate.setExchange("habits.Topic");
            String messageBody = "Hi " + clientRepository.getById(habit.getUId()) + ", it is time to work on your habits: " + habit.getDesc();
            rabbitTemplate.convertAndSend("habit-alert", messageBody);
        }
    }
}
