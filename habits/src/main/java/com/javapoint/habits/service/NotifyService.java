package com.javapoint.habits.service;

import com.javapoint.habits.model.Client;
import com.javapoint.habits.model.Habits;
import com.javapoint.habits.model.RabbitMQMessage;
import com.javapoint.habits.repository.ClientRepository;
import com.javapoint.habits.repository.HabitsRepository;
import com.javapoint.habits.repository.RabbitRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Hashtable;
import java.util.List;

@Service
public class NotifyService {
    private HabitsRepository repository;
    private ClientRepository clientRepository;
    //Репозиторий, который подключается к базе и берет привычки
    //Метод get all или find all

    private RabbitRepository mqRepository;

    public NotifyService(HabitsRepository repository, RabbitRepository mqRepository) {
        this.repository = repository;
        this.mqRepository = mqRepository;
    }

    @Scheduled(cron = "0 0 9 * * *")
    public void Notify() {
        List<Habits> habits = (List<Habits>) this.repository.findAll();
        for(Habits habit: habits) {
            Client client = this.clientRepository.getById(habit.getUId());
            RabbitMQMessage message = new RabbitMQMessage();
            message.setUserName(client.getUsername());
            message.setUserEmail(client.getEmail());
            message.setHabbitDescription(Habits.getDesc());
            this.mqRepository.send(message);
        }



    }



}
