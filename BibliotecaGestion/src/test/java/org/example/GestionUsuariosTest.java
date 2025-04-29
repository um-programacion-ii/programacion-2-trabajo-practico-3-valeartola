package org.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.recursos.Usuario;
import org.example.sistemas.GestionUsuarios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class GestionUsuariosTest {

    @Mock
    private Usuario usuarioMock;

    @InjectMocks
    private GestionUsuarios gestionUsuarios;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gestionUsuarios = new GestionUsuarios();
    }

    @Test
    void testRegistrarUsuario() {
        when(usuarioMock.getNombre()).thenReturn("Juan");
        when(usuarioMock.getApellido()).thenReturn("Pérez");

        gestionUsuarios.registrarUsuario(usuarioMock);

        assertTrue(gestionUsuarios.existeUsuario("Juan", "Pérez")); // Verifica que el usuario se registró correctamente
    }

    @Test
    void testBuscarUsuarioExistente() {
        Usuario usuario = new Usuario("Maria", "Artola");
        gestionUsuarios.registrarUsuario(usuario);

        Usuario usuarioEncontrado = gestionUsuarios.buscarUsuarioPorNombreyApellido("Maria", "Artola");

        assertNotNull(usuarioEncontrado);
        assertEquals("Maria", usuarioEncontrado.getNombre());
        assertEquals("Artola", usuarioEncontrado.getApellido());
    }

    @Test
    void testRegistrarYBuscarUsuario() {
        when(usuarioMock.getNombre()).thenReturn("Pedro");
        when(usuarioMock.getApellido()).thenReturn("Gómez");

        gestionUsuarios.registrarUsuario(usuarioMock);

        verify(usuarioMock).getNombre();
        verify(usuarioMock).getApellido();

        assertTrue(gestionUsuarios.existeUsuario("Pedro", "Gómez"));
        assertNotNull(gestionUsuarios.buscarUsuarioPorNombreyApellido("Pedro", "Gómez"));
    }

    @Test
    void testBuscarUsuarioInexistente() {
        Usuario usuarioEncontrado = gestionUsuarios.buscarUsuarioPorNombreyApellido("Carlos", "Lopez");
        assertNull(usuarioEncontrado); // No debería encontrar a un usuario que no se registró
    }

}

