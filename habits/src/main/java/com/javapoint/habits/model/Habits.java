package com.javapoint.habits.model;

import jakarta.persistence.*;
    @Entity
    @Table(name = "habits")
    public class Habits {
        @Id
        @Column(name = "habit_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer hId;

        @Id
        @Column(name = "User_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer uId;

        private String habitDesc;

        private String habitColor;
        public Integer getHId() {
            return hId;
        }
        public Integer getUId() {
            return uId;
        }

        public void setHId(Integer id) {
            this.hId = id;
        }

        public void setUId(Integer id) {
            this.uId = id;
        }

        public String getDesc() { return habitDesc;
        }

        public void setDesc(String habitDesc) { this.habitDesc = habitDesc;
        }

        public String getColor() { return habitColor;
        }

        public void setColor(String habitColor) {
            this.habitColor = habitColor;
        }
    }

