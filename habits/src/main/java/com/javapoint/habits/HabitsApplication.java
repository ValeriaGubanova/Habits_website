package com.javapoint.habits;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@SpringBootApplication
public class HabitsApplication {


		/*public static void main(String[] args) {
				String password = "password123";
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String hashedPassword = passwordEncoder.encode(password);

				System.out.println(hashedPassword);

		}*/
	public static void main(String[] args) {
		SpringApplication.run(HabitsApplication.class, args);
	}

	/*@Bean
	public ApplicationRunner runner(AmqpTemplate template) {
		return args -> template.convertAndSend("habit-alert", "foo");
	}

	@Bean
	public Queue myQueue() {
		return new Queue("habit-alert");
	}

	@RabbitListener(queues = "habit-alert")
	public void listen(String in) {
		System.out.println(in);
	}*/

}
