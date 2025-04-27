package org.example.sistemas;

import org.example.enums.EstadoLibro;
import org.example.recursos.Catalogo;
import org.example.recursos.Libro;
import org.example.recursos.Prestamo;

import java.util.ArrayList;
import java.util.List;



public class SistemaPrestamos {
    private List<Prestamo> prestamos = new ArrayList<>();
    private Catalogo catalogo;

    public SistemaPrestamos(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public List<Prestamo> getPrestamos() {
        return new ArrayList<>(prestamos);
    }

    public boolean registrarPrestamo(String isbn) {
        Libro libroEncontrado = catalogo.buscarPorISBN(isbn);
        if (libroEncontrado == null) {
            return false;
        }

        if (libroEncontrado.getEstado() != EstadoLibro.DISPONIBLE) {
            return false;
        }

        libroEncontrado.setEstado(EstadoLibro.PRESTADO);
        Prestamo nuevoPrestamo = new Prestamo(libroEncontrado);
        prestamos.add(nuevoPrestamo);
        return true;
    }

    public Prestamo buscarPrestamoPorISBN(String isbn) {
        for (Prestamo prestamo : prestamos) {
            Libro libro = prestamo.getLibro();
            String isbnLibro = libro.getIsbn();
            if (isbnLibro.equals(isbn)) {
                return prestamo;
            }
        }
        return null;
    }

}
