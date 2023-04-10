package com.javapoint.habits.Receiver;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Mail {

    private String messageId;
    private String message;
    private Date messageDate;

}
