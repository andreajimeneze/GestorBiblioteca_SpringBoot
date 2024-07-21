package cl.praxis.gestorbiblioteca.services;

import cl.praxis.gestorbiblioteca.entities.Book;

import java.util.List;

public interface IBookService {
    Book getBook(Long id);
    List<Book> getAllBooks();
    Book addBook(Book book);
    Book updateBook(Book book);
    void deleteBook(Book book);
    void deleteBook(Long id);
}
