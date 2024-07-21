package cl.praxis.gestorbiblioteca.services.impl;

import cl.praxis.gestorbiblioteca.entities.Book;
import cl.praxis.gestorbiblioteca.repositories.IBookRepository;
import cl.praxis.gestorbiblioteca.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BookService")
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Book getBook(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        return book;
    }

    @Override
    public Book getBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title);
        return book;
    }
    @Override
    public Book getBookByAuthor(String author) {
        Book book = bookRepository.findByAuthor(author);
        return book;
    }


    @Override
    public List<Book> getAllBooks() {
        List<Book> listBooks = bookRepository.findAll();
        return listBooks;
    }

    @Override
    public Book addBook(Book book) {
        Book newBook = bookRepository.save(book);
        return newBook;
    }

    @Override
    public Book updateBook(Book book) {
        Book updatedBook = bookRepository.save(book);
        return updatedBook;
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
