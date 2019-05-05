package guru.springFramwork.demo.springframework.spring5webapp.model.Controllers;

import guru.springFramwork.demo.springframework.spring5webapp.model.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    private BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        //Thymeleaf view name
        return "books";
    }
}
