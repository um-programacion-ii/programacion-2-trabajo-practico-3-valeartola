package org.example.sistemas;

import org.example.recursos.Prestamo;
import org.example.recursos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class GestionUsuarios {
    private List<Usuario> usuarios = new ArrayList<>();

    public void registrarUsuario(String nombre, String apellido) {
        if (nombre == null || nombre.isEmpty() || apellido == null || apellido.isEmpty()) {
            throw new IllegalArgumentException("El nombre y apellido no pueden estar vacíos.");
        }
        usuarios.add(new Usuario(nombre, apellido));
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return new ArrayList<>(usuarios); // copia para no modificar la lista original
    }

    public Usuario buscarUsuarioPorNombreYApellido(String nombre, String apellido) {
        return usuarios.stream()
                .filter(usuario -> usuario.getNombre().equalsIgnoreCase(nombre) &&
                        usuario.getApellido().equalsIgnoreCase(apellido))
                .findFirst()
                .orElse(null);
    }

}
