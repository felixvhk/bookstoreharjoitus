package hh.backend.bookstorefelix.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hh.backend.bookstorefelix.domain.Book;


@Controller
public class BookController {

    @RequestMapping("/index")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/index")
    public String index(Model model) {

        List<Book> books = new ArrayList<>();

        books.add(new Book("Very Cool Book", "Cole", 2020, "978-0-123456-78-9", 15));

        model.addAttribute("books", books);

        return "index";
    }
    
}
