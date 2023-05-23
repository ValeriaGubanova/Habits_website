package com.javapoint.habits.model;


public class RabbitMQMessage {
    private String habbitId;
    private String habbitDescription;
    private String userName;
    private String userEmail;

    public String getHabbitId() {
        return habbitId;
    }

    public void setHabbitId(String habbitId) {
        this.habbitId = habbitId;
    }

    public String getHabbitDescription() {
        return habbitDescription;
    }

    public void setHabbitDescription(String habbitDescription) {
        this.habbitDescription = habbitDescription;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
