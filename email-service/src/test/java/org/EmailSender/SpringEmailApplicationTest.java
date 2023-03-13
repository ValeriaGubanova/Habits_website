package org.EmailSender;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class SpringEmailApplicationTest {
    @Autowired
    private EmailSenderService emailService;

    @Rule
    public SmtpServerRule smtpServerRule = new SmtpServerRule(2525);

    @Test
    public void shouldSendSingleMail() throws MessagingException, IOException {
        Mail mail = new Mail();
        mail.setFrom("my.gmail@gmail.com");
        mail.setTo("another.gmail@gmail.com");
        mail.setSubject("Test subject for mail");
        mail.setContent("A message someone might hypothetically get");

        emailService.sendSimpleMessage(mail);

        MimeMessage[] receivedMessages = smtpServerRule.getMessages();
        assertEquals(1, receivedMessages.length);

        MimeMessage current = receivedMessages[0];

        assertEquals(mail.getSubject(), current.getSubject());
        assertEquals(mail.getTo(), current.getAllRecipients()[0].toString());
        assertTrue(String.valueOf(current.getContent()).contains(mail.getContent()));

    }
}
