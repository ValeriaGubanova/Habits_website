package com.javapoint.habits.service;


import com.javapoint.habits.model.Statistic;
import com.javapoint.habits.repository.StatisticRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService{
    private StatisticRepo repository;

    public StatisticServiceImpl(StatisticRepo repository) {
        this.repository = repository;
    }

    @Override
    public void create(Statistic statistic) {
        repository.save(statistic);
    }

    @Override
    public List<Statistic> readAll() {
        return repository.findAll();
    }

    @Override
    public Statistic read(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public boolean update(Statistic statistic, int id) {
        if (repository.existsById(id)) {
            statistic.setId_(id);
            repository.save(statistic);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }


}
