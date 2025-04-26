package org.example;

import org.example.enums.EstadoLibro;
import org.example.recursos.Catalogo;
import org.example.recursos.Libro;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CatalogoTest {

    @Test
    void testAgregarLibro() {

        Catalogo catalogo = new Catalogo();
        Libro libro = new Libro("978-950-49-7461-1", "Nosotros en la luna","Alice Kellen");

        catalogo.agregarLibro(libro);

        assertEquals(libro, catalogo.buscarPorISBN("978-950-49-7461-1"));

    }

    @Test
    void testBuscarPorISBN(){
        Catalogo catalogo = new Catalogo();
        Libro libro1 = new Libro("978-950-49-7461-1", "Nosotros en la luna","Alice Kellen");
        Libro libro2 = new Libro("978-950-732-524-3", "Cuando no queden más estrellas que contar", "María Martínez");

        catalogo.agregarLibro(libro1);
        catalogo.agregarLibro(libro2);

        Libro encontrado = catalogo.buscarPorISBN(("978-950-732-524-3"));
        assertNotNull(encontrado);
        assertEquals(libro2, encontrado);

    }

    @Test
    void testObtenerLibrosDisponibles() {
        Catalogo catalogo = new Catalogo();

        Libro libro1 = new Libro("978-950-49-7461-1", "Nosotros en la luna","Alice Kellen");
        Libro libro2 = new Libro("978-950-732-524-3", "Cuando no queden más estrellas que contar", "María Martínez");


        Libro libro3 = new Libro("978-84-92918-79-9", "Asesino de brujas", "Shelby Mahurin");
        libro3.setEstado(EstadoLibro.PRESTADO);

        catalogo.agregarLibro(libro1);
        catalogo.agregarLibro(libro2);
        catalogo.agregarLibro(libro3);

        List<Libro> disponibles = catalogo.obtenerLibrosDisponibles();

        assertEquals(2, disponibles.size());
        assertTrue(disponibles.contains(libro1));
        assertTrue(disponibles.contains(libro2));
        assertFalse(disponibles.contains(libro3));
    }
}
