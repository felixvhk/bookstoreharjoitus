package hh.backend.bookstorefelix;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.backend.bookstorefelix.domain.Book;
import hh.backend.bookstorefelix.domain.BookRepository;

@SpringBootApplication
public class BookstorefelixApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstorefelixApplication.class, args);
	}

	// http://localhost:8080/index
	// http://localhost:8080/h2-console

	// jdbc:h2:mem:testdb

	// http://localhost:8080/booklist

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			Book book1 = new Book( 
				"J.K. Rowling", 
				"Harry Potter and the Philosopher's Stone", 
				"9780747532699", 
				1997
			);

			bookRepository.save(book1);
		};
	}

}
