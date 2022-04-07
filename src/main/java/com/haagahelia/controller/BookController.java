package com.haagahelia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haagahelia.model.Book;
import com.haagahelia.model.BookRepository;

@RestController
public class BookController {

	@GetMapping({"/", "/index"})
	public String index() {
		return "This is the index page";
	}

	@Autowired
	private BookRepository repository;

	@GetMapping("bookList")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "bookList";
	}
	
	@GetMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book",new Book());
		return "addBook";
	}
	
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
}
