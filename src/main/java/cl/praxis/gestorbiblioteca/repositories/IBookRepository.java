package cl.praxis.gestorbiblioteca.repositories;

import cl.praxis.gestorbiblioteca.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
    Book findByAuthor(String author);

}
