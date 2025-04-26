package org.example.recursos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.enums.EstadoLibros;
@Data
@NoArgsConstructor


public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private EstadoLibros estado = EstadoLibros.DISPONIBLE;


    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }
    
}
