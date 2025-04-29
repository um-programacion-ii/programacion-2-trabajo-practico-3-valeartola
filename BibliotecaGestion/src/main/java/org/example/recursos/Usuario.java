package org.example.recursos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Usuario {
    private String nombre;
    private String apellido;
    private List<Prestamo> historialPrestamos = new ArrayList<>();

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void agregarPrestamo(Prestamo prestamo) {
        historialPrestamos.add(prestamo);
    }

}
