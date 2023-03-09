package com.javapoint.habits.model;


import jakarta.persistence.*;


import java.sql.Date;

@Entity
@Table(schema = "public", name = "statistics")
public class Statistic {
    @Id
    @Column(name = "user_id", nullable = false, unique=true)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer user_id;

    @Column(name = "cnt_habits")
    private Integer cnt_habits;

    @Column(name = "date_end")
    private String date_end;

    @Column(name = "date_start")
    private String date_start;


    public Integer getId() {
        return user_id;
    }

    public void setId_(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getCnt_habits() {
        return cnt_habits;
    }

    public void setCnt_habits(Integer cnt_habits) {
        this.cnt_habits = cnt_habits;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getDate_start() {return date_start;}
    public void setDate_start( String date_start) { this.date_start = date_start;}

}
