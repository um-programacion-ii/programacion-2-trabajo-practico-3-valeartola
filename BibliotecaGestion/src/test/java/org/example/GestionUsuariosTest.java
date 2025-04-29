package org.example;

import org.example.recursos.Usuario;
import org.example.sistemas.GestionUsuarios;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GestionUsuariosTest {

    @Mock
    private Usuario usuarioMock;

    private GestionUsuarios gestionUsuarios;

    @BeforeEach
    void setUp() { // No debe ser "public"
        MockitoAnnotations.openMocks(this);
        gestionUsuarios = new GestionUsuarios();
    }

    @Test
    void testRegistrarUsuario() {
        gestionUsuarios.registrarUsuario("Maria", "Artola");

        List<Usuario> usuarios = gestionUsuarios.obtenerTodosLosUsuarios();
        assertEquals(1, usuarios.size());
        assertEquals("Maria", usuarios.get(0).getNombre());
    }

    @Test
    void testBuscarUsuarioMock() {
        when(usuarioMock.getNombre()).thenReturn("Mauro");
        when(usuarioMock.getApellido()).thenReturn("Codina");

        gestionUsuarios.registrarUsuario("Mauro", "Codina");
        Usuario encontrado = gestionUsuarios.buscarUsuarioPorNombreYApellido("Mauro", "Codina");

        assertNotNull(encontrado);
        assertEquals("Carlos", encontrado.getNombre());
    }

    @Test
    void testRegistrarUsuarioNombreVacio() {
        assertThrows(IllegalArgumentException.class, () -> {
            gestionUsuarios.registrarUsuario("", "Artola");
        });
    }
}