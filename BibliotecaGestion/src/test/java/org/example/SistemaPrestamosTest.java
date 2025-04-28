package org.example;


import org.example.enums.EstadoLibro;
import org.example.recursos.Catalogo;
import org.example.recursos.Libro;
import org.example.recursos.Prestamo;
import org.example.sistemas.SistemaPrestamos;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SistemaPrestamosTest {

    @Mock
    private Catalogo catalogoMock;

    @InjectMocks
    private SistemaPrestamos sistemaPrestamos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPrestarLibro() {

        Libro libro1 = new Libro("978-950-49-7461-1", "Nosotros en la luna", "Alice Kellen");
        when(catalogoMock.buscarPorISBN("978-950-49-7461-1")).thenReturn(libro1);

        // Act
        boolean resultado = sistemaPrestamos.registrarPrestamo("978-950-49-7461-1");

        // Assert
        assertTrue(resultado);
        verify(catalogoMock).buscarPorISBN("978-950-49-7461-1");
        assertEquals(EstadoLibro.PRESTADO, libro1.getEstado());
    }

    @Test
    void testRegistrarPrestamoFallidoLibroPrestado() {
        // Arrange
        Libro libroPrestado = new Libro("978-0-13-235088-4", "The Clean Coder", "Robert C. Martin");
        libroPrestado.setEstado(EstadoLibro.PRESTADO); // ya está prestado
        when(catalogoMock.buscarPorISBN("978-0-13-235088-4")).thenReturn(libroPrestado);

        // Act
        boolean resultado = sistemaPrestamos.registrarPrestamo("978-0-13-235088-4");

        // Assert
        assertFalse(resultado, "El préstamo debería fallar porque el libro ya está prestado");
        verify(catalogoMock).buscarPorISBN("978-0-13-235088-4");
        assertEquals(EstadoLibro.PRESTADO, libroPrestado.getEstado(), "El estado debería seguir siendo PRESTADO");
    }

    
}
