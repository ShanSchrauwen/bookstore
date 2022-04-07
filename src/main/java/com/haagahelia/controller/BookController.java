package com.haagahelia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@GetMapping("/index")
	public String index() {
		return "This is the index page";
	}
}
