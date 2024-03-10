package com.example.teachershedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class TeacherScheduleApplication {
	public static void main(String[] args) {
		SpringApplication.run(TeacherScheduleApplication.class, args); 
	}
}
