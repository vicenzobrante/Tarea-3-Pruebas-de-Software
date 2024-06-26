package tarea3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.junit.Assert;





public class UsuarioTest {
	@Mock
	private Scanner input = Mockito.mock(Scanner.class);

	@Mock
	private List<String> usuarios_empty = new ArrayList<>();
	private List<String> usuarios = new ArrayList<>();
	@InjectMocks
	private static Usuario usuario;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testListaUsuario() {
		Assert.assertEquals(Usuario.ListaUsuario(usuarios),"Ok");
	}

	@Test
	public void testCrearUsuario() {
		Mockito.when(input.nextLine()).thenReturn("Test 1").thenReturn("Test 2").thenReturn("Test 3");
		Assert.assertEquals(Usuario.CrearUsuario(input,usuarios_empty), "Usuario Test 1 fue creado exitosamente");
	}

	@Test
	public void testEditarUsuario() {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testEliminarUsuario() {
		throw new RuntimeException("not yet implemented");
	}

}
