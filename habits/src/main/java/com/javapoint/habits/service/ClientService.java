package com.javapoint.habits.service;

import com.javapoint.habits.model.Client;

import java.util.List;

public interface ClientService {
    /**
     * Создает нового клиента
     * @param client - клиент для создания
     */
    void create(Client client);

    /**
     * Возвращает список всех имеющихся клиентов
     * @return список клиентов
     */
    List<Client> readAll();

    /**
     * Возвращает клиента по его ID
     * @param user_id - ID клиента
     * @return - объект клиента с заданным ID
     */
    Client read(int user_id);

    /**
     * Обновляет клиента с заданным ID,
     * в соответствии с переданным клиентом
     * @param client - клиент в соответсвии с которым нужно обновить данные
     * @param user_id - id клиента которого нужно обновить
     * @return - true если данные были обновлены, иначе false
     */
    //boolean update(Client client, int user_id);

    boolean update(Client client, int id);

    /**
     * Удаляет клиента с заданным ID
     * @param user_id - id клиента, которого нужно удалить
     * @return - true если клиент был удален, иначе false
     */
    boolean delete(int user_id);
}