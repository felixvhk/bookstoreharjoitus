package hh.backend.bookstorefelix;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import hh.backend.bookstorefelix.domain.Book;
import hh.backend.bookstorefelix.domain.BookRepository;

import hh.backend.bookstorefelix.domain.Category;
import hh.backend.bookstorefelix.domain.CategoryRepository;

@SpringBootApplication
public class BookstorefelixApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstorefelixApplication.class, args);
	}

	// http://localhost:8080/index
	// http://localhost:8080/h2-console
	// http://localhost:8080/booklist

	// http://localhost:8080/books
	// http://localhost:8080/books/2

	// jdbc:h2:mem:testdb

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {

			Category fantasy = new Category("Fantasy");
			Category fiction = new Category("Fiction");
			Category programming = new Category("Programming");

			categoryRepository.save(fantasy);
			categoryRepository.save(fiction);
			categoryRepository.save(programming);

			Book book1 = new Book( 
				"J.K. Rowling", 
				"Harry Potter and the Philosopher's Stone", 
				"9780747532699", 
				1997,
				fantasy
			);
			bookRepository.save(book1);

			Book book2 = new Book( 
				"Aku Ankka", 
				"Aku Ankka ja salaperäinen saari", 
				"9780747532629", 
				2005,
				fiction
			);
			bookRepository.save(book2);

			Book book3 = new Book( 
				"Darth Vader", 
				"The Dark Side of the Force", 
				"9780747532630", 
				1980,
				programming
			);
			bookRepository.save(book3);

			for (Book book : bookRepository.findAll()) {
				System.out.println(book);
			}
		};
	}

}
