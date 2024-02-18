package com.example.demo.controller;

import com.example.demo.data.RequestData;
import com.example.demo.service.Logic;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller
{
	@GetMapping("/search")
	public RequestData search(@RequestParam(value = "request") String query)
	{
		return Logic.searchInfoByQuery(query);
	}
}