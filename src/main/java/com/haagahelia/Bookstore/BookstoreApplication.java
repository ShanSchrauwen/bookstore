package com.haagahelia.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.haagahelia.model.Book;
import com.haagahelia.model.BookRepository;
import com.haagahelia.model.Category;
import com.haagahelia.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repo, CategoryRepository crepo) {
		return (agrs) -> {
			log.info("save a few books");
			crepo.save(new Category("Fantasy"));
			crepo.save(new Category("Fiction"));
			crepo.save(new Category("Non-Fiction"));
			crepo.save(new Category("Young Adult"));

			repo.save(new Book("Harry Potter", "JK Rowling", 1996, "123780886", 5.99,
					crepo.findByCategoryName("Young Adult").get(0)));
			repo.save(new Book("Warbreaker", "Brandon Sanderson", 2002, "1234354364578", 7.99,
					crepo.findByCategoryName("Fantasy").get(0)));
			repo.save(new Book("Spud", "John van der Ruit", 2010, "12346732345", 1.99,
					crepo.findByCategoryName("Fiction").get(0)));
			repo.save(new Book("Hacking Growth", "Sean Ellis", 2020, "123489345473712", 10,
					crepo.findByCategoryName("Non-Fiction").get(0)));

			log.info("fetch all books");
			for (Book book : repo.findAll()) {
				log.info(book.toString());
			}

		};
	}

}
