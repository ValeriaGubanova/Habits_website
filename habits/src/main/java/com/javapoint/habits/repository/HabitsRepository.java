package com.javapoint.habits.repository;

import com.javapoint.habits.model.Habits;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitsRepository {

    public Habits findAll();
            //@Param("habit_desc") String habitDesc);

    @SuppressWarnings("unchecked")
    public List<Habits> findHabitsByUserId(int userId);
}
