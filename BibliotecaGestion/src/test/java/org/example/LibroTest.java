package org.example;

import org.example.enums.EstadoLibro;
import org.example.recursos.Libro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class LibroTest {

    @Test
    public void testCrearLibroValido() {
        Libro libro = new Libro("978-950-49-7461-1", "Nosotros en la luna","Alice Kellen");
        assertEquals("978-950-49-7461-1", libro.getIsbn());
        assertEquals("Nosotros en la luna", libro.getTitulo());
        assertEquals("Alice Kellen", libro.getAutor());
        assertEquals(EstadoLibro.DISPONIBLE, libro.getEstado());
    }

    @Test
    public void testCambioEstadoLibro() {
        Libro libro = new Libro("978-950-49-7461-1", "Nosotros en la luna","Alice Kellen");

        libro.setEstado(EstadoLibro.PRESTADO);
        assertEquals(EstadoLibro.PRESTADO, libro.getEstado());

        libro.setEstado(EstadoLibro.DISPONIBLE);
        assertEquals(EstadoLibro.DISPONIBLE, libro.getEstado());

    }
}
