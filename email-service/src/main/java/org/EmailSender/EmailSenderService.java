package org.EmailSender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class EmailSenderService {
    private JavaMailSender emailSender;

    public EmailSenderService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @RabbitListener(queues="${rabbitmq.queue}")
    public void consume(Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        //username?
        message.setTo(mail.getEmail());
        message.setText(mail.getHabit_desc());

        emailSender.send(message);
        //log.info(mail);
    }
}
