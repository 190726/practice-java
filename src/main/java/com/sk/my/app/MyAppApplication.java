package com.sk.my.app;

import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
	}

	@RestController
	public static class UserController{
		@GetMapping("/users")
		public List<User> all(){
			return List.of(new User("lee", 1), new User("kim",2));
		}
	}

	@ToString
	@NoArgsConstructor
	@AllArgsConstructor
	@Setter
	@Getter
	public static class User{
		String name;
		int age;
	}

}