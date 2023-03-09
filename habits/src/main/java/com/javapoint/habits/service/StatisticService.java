package com.javapoint.habits.service;


import com.javapoint.habits.model.Statistic;

import java.util.List;

public interface StatisticService {
    void create(Statistic statistic);
    List<Statistic> readAll();
    Statistic read(int user_id);

    boolean update(Statistic statistic, int user_id);
    boolean delete(int user_id);


}
