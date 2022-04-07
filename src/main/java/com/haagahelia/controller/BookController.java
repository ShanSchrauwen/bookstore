package com.haagahelia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haagahelia.model.Book;
import com.haagahelia.model.BookRepository;
import com.haagahelia.model.CategoryRepository;

@RestController
public class BookController {
	//front page
	@GetMapping({"/", "/index"})
	public String index() {
		return "This is the index page";
	}

	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepo;
	
	//show all books
	@GetMapping("bookList")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "bookList";
	}
	
	//add new book
	@GetMapping("/add")
	public String addBook(Model model) {
		model.addAttribute("book",new Book());
		model.addAttribute("categorys", crepo.findAll());
		return "addBook";
	}
	
	@PostMapping("/save")
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}
	
	//delete book
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	//edit book
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("student", repository.findById(bookId));
		model.addAttribute("categories", crepo.findAll());
		return "editBook";
	}
}
