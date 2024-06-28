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

public class ReservaTest {
	@Mock
	private Scanner input = Mockito.mock(Scanner.class);

	@Mock
	private List<String> reservas_empty = new ArrayList<>();
	private List<String> reservas_create = new ArrayList<>();
	private List<String> reservas_edit = new ArrayList<>();
	private List<String> reservas_edit_2 = new ArrayList<>();
	private List<String> reservas_delete = new ArrayList<>();
	private List<String> reservas_delete_2 = new ArrayList<>();
	private List<String> reservas = new ArrayList<>();
	@InjectMocks
	private static Reserva reserva;
	
	
	@Before
	public void setUp() throws Exception {
	}
	
	
	@Test
	public void testListaReserva() {
		reservas.add("0;0;25-06-2024;Reunion");
		reservas.add("1;0;25-06-2024;Conferencia");
		Assert.assertEquals(Reserva.ListaReserva(reservas),"Ok");
	}

	
	@Test
	public void testListaReserva_lista_vacia() {
		Assert.assertEquals(Reserva.ListaReserva(reservas_empty),"Ok");
	}

	@Test
	public void testCrearReserva() {
		Mockito.when(input.nextLine()).thenReturn("0").thenReturn("0").thenReturn("25-06-2024").thenReturn("Conferencia");
		Assert.assertEquals(Reserva.CrearReserva(input,reservas_create),"Reserva creada exitosamente");
	}
	
	@Test
	public void testCrearReserva_campos_vacios() {
		Mockito.when(input.nextLine()).thenReturn("").thenReturn("").thenReturn("").thenReturn("").thenReturn("0").thenReturn("0").thenReturn("25-06-2024").thenReturn("Conferencia");
		Assert.assertEquals(Reserva.CrearReserva(input,reservas_create),"Reserva creada exitosamente");
	}

	@Test
	public void testEditarReserva() {
		reservas_edit.add("0;0;24-06-2023;Reunion");
		Mockito.when(input.nextLine()).thenReturn("0").thenReturn("0").thenReturn("24-06-2023").thenReturn("0").thenReturn("1").thenReturn("30-10-2023").thenReturn("Reunion del equipo");
		Assert.assertEquals(Reserva.EditarReserva(input, reservas_edit), "Reserva editada exitosamente");
	}
	
	@Test
	public void testEditarReserva_campos_vacios() {
		reservas_edit_2.add("0;0;24-06-2023;Reunion");
		Mockito.when(input.nextLine()).thenReturn("").thenReturn("").thenReturn("").thenReturn("0").thenReturn("0").thenReturn("24-06-2023").thenReturn("").thenReturn("").thenReturn("").thenReturn("").thenReturn("0").thenReturn("1").thenReturn("30-10-2023").thenReturn("Reunion del equipo");
		Assert.assertEquals(Reserva.EditarReserva(input, reservas_edit_2), "Reserva editada exitosamente");
	}
	
	@Test
	public void testEditarReserva_lista_vacia() {
		Assert.assertEquals(Reserva.EditarReserva(input, reservas_empty), "No hay reservas");
	}

	@Test
	public void testEliminarReserva() {
		reservas_delete.add("0;0;24-06-2023;Reunion");
		reservas_delete.add("1;0;25-06-2024;Conferencia");
		Mockito.when(input.nextLine()).thenReturn("0").thenReturn("0").thenReturn("24-06-2023");
		Assert.assertEquals(Reserva.EliminarReserva(input, reservas_delete),"Reserva eliminada exitosamente");
	}
	
	@Test
	public void testEliminarReserva_lista_vacia() {
		Assert.assertEquals(Reserva.EliminarReserva(input, reservas_empty),"No hay reservas");
	}
	
	@Test
	public void testEliminarReserva_campos_erroneos() {
		reservas_delete_2.add("0;0;24-06-2023;Reunion");
		reservas_delete_2.add("1;0;25-06-2024;Conferencia");
		Mockito.when(input.nextLine()).thenReturn("0").thenReturn("1").thenReturn("24-06-2023");
		Assert.assertEquals(Reserva.EliminarReserva(input, reservas_delete_2),"No hay una reserva con esos datos");
	}

}
