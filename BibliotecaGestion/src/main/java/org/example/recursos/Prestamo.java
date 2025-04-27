package org.example.recursos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Prestamo {
    private LocalDate fechaPrestamo;
    private Libro libro;

    public Prestamo(Libro libro) {
        this.fechaPrestamo = LocalDate.now();
        this.libro = libro;
    }

}
