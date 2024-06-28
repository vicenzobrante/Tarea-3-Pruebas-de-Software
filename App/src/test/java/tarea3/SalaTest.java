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

public class SalaTest {
	
	@Mock
	private Scanner input = Mockito.mock(Scanner.class);

	@Mock
	private List<String> salas_empty = new ArrayList<>();
	private List<String> salas_create = new ArrayList<>();
	private List<String> salas_edit = new ArrayList<>();
	private List<String> salas_edit_2 = new ArrayList<>();
	private List<String> salas_delete = new ArrayList<>();
	private List<String> salas_delete_2 = new ArrayList<>();
	private List<String> salas = new ArrayList<>();
	@InjectMocks
	private static Sala sala;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testListaSala() {
		salas.add("0;Sala 1;Piso 1");
		salas.add("1;Sala 2;Piso 1");
		Assert.assertEquals(Sala.ListaSala(salas),"Ok");
	}

	
	@Test
	public void testListaSala_lista_vacia() {
		Assert.assertEquals(Sala.ListaSala(salas_empty),"Ok");
	}

	@Test
	public void testCrearSala() {
		Mockito.when(input.nextLine()).thenReturn("Sala 1").thenReturn("Piso 1");
		Assert.assertEquals(Sala.CrearSala(input,salas_create),"Sala creada con nombre Sala 1 exitosamente");
	}
	
	@Test
	public void testCrearSala_campos_vacios() {
		Mockito.when(input.nextLine()).thenReturn("").thenReturn("").thenReturn("Sala 1").thenReturn("Piso 1");
		Assert.assertEquals(Sala.CrearSala(input,salas_create),"Sala creada con nombre Sala 1 exitosamente");
	}

	@Test
	public void testEditarSala() {
		salas_edit.add("0;Sala 1;Piso 1");
		salas_edit.add("1;Sala 2;Piso 1");
		Mockito.when(input.nextLine()).thenReturn("0").thenReturn("Sala 3").thenReturn("Piso 2");
		Assert.assertEquals(Sala.EditarSala(input, salas_edit), "Sala con código 0 editada exitosamente");
	}
	
	@Test
	public void testEditarSala_campos_vacios() {
		salas_edit_2.add("0;Sala 1;Piso 1");
		salas_edit_2.add("1;Sala 2;Piso 1");
		Mockito.when(input.nextLine()).thenReturn("").thenReturn("0").thenReturn("Sala 3").thenReturn("Piso 2");
		Assert.assertEquals(Sala.EditarSala(input, salas_edit_2), "Sala con código 0 editada exitosamente");
	}
	
	@Test
	public void testEditarSala_lista_vacia() {
		Assert.assertEquals(Sala.EditarSala(input, salas_empty), "No hay salas registradas");
	}

	@Test
	public void testEliminarSala() {
		salas_delete.add("0;Sala 1;Piso 1");
		salas_delete.add("1;Sala 2;Piso 1");
		Mockito.when(input.nextLine()).thenReturn("0");
		Assert.assertEquals(Sala.EliminarSala(input, salas_delete),"Sala eliminada exitosamente");
	}
	
	@Test
	public void testEliminarSala_lista_vacia() {
		Assert.assertEquals(Sala.EliminarSala(input, salas_empty),"No hay salas registradas");
	}
	
	@Test
	public void testEliminarSala_campos_erroneos() {
		salas_delete_2.add("0;Sala 1;Piso 1");
		salas_delete_2.add("1;Sala 2;Piso 1");
		Mockito.when(input.nextLine()).thenReturn("").thenReturn("0");
		Assert.assertEquals(Sala.EliminarSala(input, salas_delete_2),"No hay una sala con ese código");
	}

}
