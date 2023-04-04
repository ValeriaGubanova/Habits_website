package com.javapoint.habits.service;

import com.javapoint.habits.repository.RabbitRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class NotifyService {
    private RabbitRepository repository;

    @Scheduled(cron = "0 0 9 * * *")
    public void Notify() {

        //брать привычки из базы, запускать цикл сообщений
    }

    // вызвать репозиторий и передать сообщение
}
