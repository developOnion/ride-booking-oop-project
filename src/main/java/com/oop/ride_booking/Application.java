package com.oop.ride_booking;

import com.oop.ride_booking.user.Gender;
import com.oop.ride_booking.user.User;
import com.oop.ride_booking.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRepository userRepository) {
		return args -> {
			User user = new User(
					1L,
					"Nou",
					"Reaksmey",
					"smeyonion.nou@gmail.com",
					"85581525959",
					LocalDate.of(2007, 4, 14),
					Gender.MALE,
					LocalDateTime.now(),
					null);

			userRepository.createUser(user);
		};
	}
}
