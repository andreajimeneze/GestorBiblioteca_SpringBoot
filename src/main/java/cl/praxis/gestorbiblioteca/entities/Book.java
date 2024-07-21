package cl.praxis.gestorbiblioteca.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="libros")
public class Book {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="id_libro", nullable = false )
    private long id;
    @Column(name = "titulo", nullable = false, length = 100)
    private String title;
    @Column(name = "autor", length = 100, nullable = false)
    private String author;
    @Column(name = "editorial", length = 100)
    private String editorial;
    @Column(name = "anio_edicion", length = 30)
    private String yearEdition;
    @Column(name = "numero_paginas")
    private int pages;
}
