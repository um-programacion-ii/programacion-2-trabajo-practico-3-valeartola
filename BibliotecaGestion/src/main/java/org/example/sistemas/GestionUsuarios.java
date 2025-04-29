package org.example.sistemas;

import org.example.recursos.Usuario;

import java.util.HashMap;
import java.util.Map;

public class GestionUsuarios {

    private Map<String, Usuario> usuarios;

    public GestionUsuarios() {
        this.usuarios = new HashMap<>();
    }

    public void registrarUsuario(Usuario usuario) {
        String clave = usuario.getNombre() + " " + usuario.getApellido();
        usuarios.put(clave, usuario);
    }

    // Buscar usuario usando nombre y apellido
    public Usuario buscarUsuarioPorNombreyApellido(String nombre, String apellido) {
        String clave = nombre + " " + apellido; // Concatenamos para la búsqueda
        return usuarios.get(clave);
    }

    // Verificar si un usuario existe usando nombre y apellido
    public boolean existeUsuario(String nombre, String apellido) {
        String clave = nombre + " " + apellido;
        return usuarios.containsKey(clave);
    }

}
