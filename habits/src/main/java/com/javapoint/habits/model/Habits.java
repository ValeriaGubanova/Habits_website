package com.javapoint.habits.model;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(schema = "public", name = "habit_data")
public class Habits {

    public Integer habit_id;
    public Integer User_id;
    public String habit_desc;
    public String habit_color;


}
