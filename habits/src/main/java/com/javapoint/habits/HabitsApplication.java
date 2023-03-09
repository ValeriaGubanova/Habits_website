package com.javapoint.habits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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


}
