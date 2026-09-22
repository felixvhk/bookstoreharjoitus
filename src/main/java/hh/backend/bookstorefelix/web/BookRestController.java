package hh.backend.bookstorefelix.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import hh.backend.bookstorefelix.domain.Book;
import hh.backend.bookstorefelix.domain.BookRepository;

@RestController
public class BookRestController {

    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public Iterable<Book> bookListRest() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBookRest(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }
}