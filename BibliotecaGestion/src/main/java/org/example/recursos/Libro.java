package org.example.recursos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.EstadoLibro;
@Data
@NoArgsConstructor


public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private EstadoLibro estado = EstadoLibro.DISPONIBLE;


    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

}
