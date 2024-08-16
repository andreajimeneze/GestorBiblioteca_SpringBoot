package cl.praxis.gestorbiblioteca.controllers;

import cl.praxis.gestorbiblioteca.GestorBibliotecaApplication;
import cl.praxis.gestorbiblioteca.entities.Book;
import cl.praxis.gestorbiblioteca.services.impl.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gestor")
public class GestorController {
      private final BookService bookService;
    @Autowired
    public GestorController(BookService bookService) {
        this.bookService = bookService;
    }
    private static final Logger LOG = LoggerFactory.getLogger(GestorBibliotecaApplication.class);

    //Enrutamiento a métodos post y put
    @GetMapping("/addbook")
    public String showFormAdd() {
        return "form";
    }

    @GetMapping("/edit")
    public String showFormEdit(@RequestParam Long id, Model model) {
        Book book = bookService.getBook(id);

        if(book != null) {
            LOG.info("Libro " + book.getTitle() + " encontrado");
            model.addAttribute("book", book);
            return "form";
        } else {
            LOG.error("Libro no existe");
            return "index";
        }
    }


    //Crud agregar nuevo libro
    @PostMapping
    public String addBook(@ModelAttribute Book book) {
        LOG.info("Añadiendo nuevo libro");
        bookService.addBook(book);
        LOG.info("Libro añadido: " + book.getTitle());
        return "redirect:/allbooks";
    }

    //Crud editar libro
    @PutMapping
    public String editBook(@ModelAttribute Book book) {
        LOG.info("Editando libro: " + book.getTitle());
        bookService.updateBook(book);
        return "redirect:/allbooks";
    }


    //Crud ver todos los libros
    @GetMapping("/allbooks")
    public String getAllBooks(Model model) {
        LOG.info("Mostrando listado de libros");
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "list";
    }

    //Obtener libro por título
    @GetMapping("/bytitle")
    public String getBookByTitle(@RequestParam String title, @ModelAttribute Book book) {
        Book titleBook = bookService.getBookByTitle(title);

        if(titleBook != null) {
            LOG.info("Editando Libro " + titleBook.getTitle());
            bookService.getBookByTitle(title);
            return "redirect:/allbooks";
        } else {
            LOG.error("Libro no encontrado");
            return "index";
        }
    }

    //Obtener libro por autor
    @GetMapping("/byauthor")
    public String getBookByAuthor(@RequestParam String author, @ModelAttribute Book book) {

        Book authorBook = bookService.getBookByAuthor(author);

        if(authorBook.getAuthor().equals(author)) {
            bookService.getBookByTitle(authorBook.getTitle());
            return "redirect:/allbooks";
        } else {
            return "index";
        }
    }

    @DeleteMapping("/delete")
    public String deleteBook(@RequestParam Long id, @ModelAttribute Book book) {
        Book deletedBook = bookService.getBook(id);
        if(deletedBook != null) {
            bookService.deleteBook(id);
            return "redirect:/allbooks";
        } else {
            return "index";
        }
    }

    @GetMapping("/message")
    public String LogMessage() {
        String message = "un mensaje";
        LOG.info("Se envía" + message);

        String response = message;
        return response;
    }

}
