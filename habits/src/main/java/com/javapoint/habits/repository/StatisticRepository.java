package com.javapoint.habits.repository;


import com.javapoint.habits.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic, Integer> {
}
