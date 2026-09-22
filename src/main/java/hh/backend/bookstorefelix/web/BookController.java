package hh.backend.bookstorefelix.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.backend.bookstorefelix.domain.Book;
import hh.backend.bookstorefelix.domain.BookRepository;
import hh.backend.bookstorefelix.domain.CategoryRepository;

@Controller
public class BookController {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    // Show all books
    @RequestMapping("/booklist")
    public String showBookList(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    // Show add book form
    @RequestMapping("/addbook")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book("", "", "", 0, null));
        model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    }

    // Save new book
    @RequestMapping("/save")
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    // Delete book
    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    // Show edit form
    @RequestMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book id: " + id));

        model.addAttribute("book", book);
        model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    }

}
