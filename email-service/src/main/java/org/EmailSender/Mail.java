package org.EmailSender;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString*/
public class Mail {
    /*
        private String messageId;
        private String message;
        private Date messageDate;

    }*/
    private String from;
    private String to;
    private String subject;
    private String content;

    public Mail() {
    }

    public Mail(String from, String to, String subject, String content) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Mail {" +
                "from '" + from + '\'' +
                ", to '" + to + '\'' +
                ", subject '" + subject + '\'' +
                ", content '" + content + '\'' +
                '}';
    }
}
