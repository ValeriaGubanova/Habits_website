package com.javapoint.habits.service;

import com.javapoint.habits.repository.RabbitRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

@Service
public class NotifyService {
    private RabbitRepository repository;

    public Hashtable<Integer, String> HabbitQ = new Hashtable<Integer, String>();

    @Scheduled(cron = "0 0 9 * * *")
    public void Notify(Integer habit_id, String habit_desc) {

        while (habit_desc != null) {
            HabbitQ.put(habit_id, habit_desc);
        }
        //брать привычки из базы, запускать цикл сообщений
    }
    //RabbitRepository.Notify(mess);

    // вызвать репозиторий и передать сообщение
}
