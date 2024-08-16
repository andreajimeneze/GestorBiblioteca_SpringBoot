package cl.praxis.gestorbiblioteca.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="libros")
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long id;
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
