package cl.praxis.gestorbiblioteca.services.impl;

import cl.praxis.gestorbiblioteca.entities.Book;
import cl.praxis.gestorbiblioteca.repositories.IBookRepository;
import cl.praxis.gestorbiblioteca.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service("BookService")
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
    @Override
    public Book getBookByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {
        Optional<Book> selectedBook = bookRepository.findById(book.getId());
        if(selectedBook != null) {
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
