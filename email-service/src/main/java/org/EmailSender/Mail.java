package org.EmailSender;

public class Mail {
    private String username;
    private String habit_desc;
    private String email;

    public Mail() {
    }

    public Mail(String username, String habit_desc, String email) {
        this.username = username;
        this.habit_desc = habit_desc;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getHabit_desc() {
        return habit_desc;
    }

    public void setHabit_desc(String habit_desc) {
        this.habit_desc = habit_desc;
    }

    @Override
    public String toString() {
        return "Mail {" +
                ", to '" + username + '\'' +
                ", content '" + habit_desc + '\'' +
                '}';
    }
}
