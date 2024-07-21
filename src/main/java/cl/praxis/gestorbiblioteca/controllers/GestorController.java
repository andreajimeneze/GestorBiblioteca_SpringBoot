package cl.praxis.gestorbiblioteca.controllers;

import cl.praxis.gestorbiblioteca.GestorBibliotecaApplication;
import cl.praxis.gestorbiblioteca.entities.Book;
import cl.praxis.gestorbiblioteca.services.impl.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gestor")
public class GestorController {
    private static final Logger Log = LoggerFactory.getLogger(GestorBibliotecaApplication.class);

    public BookService bookService;
    @Autowired
    public GestorController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addbook")
    public String addBook(Book book) {
        bookService.addBook(book);
        Log.info("Libro añadido: " + book.getTitle());
        return "Libro añadido correctamente";
    }

    @GetMapping("/allbooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/bytitle")
    public Book getBookByTitle(String title) {
        return bookService.getBookByTitle(title);
    }

    @GetMapping("/byauthor")
    public Book getBookByAuthor(String author) {
        return bookService.getBookByAuthor(author);
    }
    @GetMapping("/message")
    public String LogMessage() {
        String message = "un mensaje";
        Log.info("Se envía" + message);

        String response = message;
        return response;
    }

}
