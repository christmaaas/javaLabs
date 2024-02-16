package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Controller {

	public static void main(String[] args)
	{
		SpringApplication.run(Controller.class, args);
	}

	@GetMapping("/search")
	public Logic search(@RequestParam(value = "term") String query)
	{
		Logic logic = new Logic();

		logic.searchInfoByQuery(query);

		return logic;
	}
}