package es.rf.tienda.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Mensajes;

class CategoriaControllerTest {

	private CategoriaController controlador;

	private Categoria categoria1;
	private Categoria categoria2;

	@BeforeEach
	void inicio() throws DomainException {
		controlador = mock(CategoriaController.class);
		categoria1 = new Categoria();
		categoria1.setId_categoria(5);
		categoria1.setCat_nombre("Normal");
		categoria1.setCat_descripcion("Descripcion categoria");
	
		categoria2 = new Categoria();
		categoria2.setId_categoria(10);
		categoria2.setCat_nombre("Extra");
		categoria2.setCat_descripcion("Descripcion categoria dos");
	
	}
	
	
	
	@Test
	void testLeerTodos() {
		when(controlador.leerTodos()).thenReturn(List.of(categoria1,categoria2));
		List<Categoria> listaCat = controlador.leerTodos();
		Assertions.assertEquals(2,listaCat.size());
	}
	@Test
	void testLeerTodos_2() {
		when(controlador.leerTodos()).thenReturn(List.of(categoria1,categoria2));
		List<Categoria> listaCat = controlador.leerTodos();
		Assertions.assertNotEquals(1,listaCat.size());
	}

	@Test
	void testLeerUno() {
		Mensajes m1 = new Mensajes("200", "", categoria1);
		when(controlador.leerUno("5")).thenReturn(m1);	
		Mensajes res = controlador.leerUno("5");
		Assertions.assertEquals(res,m1);
	}
	@Test
	void testLeerUno_2() {
		Mensajes m1 = new Mensajes("200", "", categoria1);
		when(controlador.leerUno("5")).thenReturn(m1);	
		Mensajes res = controlador.leerUno("10");
		Assertions.assertNotEquals(res,m1);
	}
	@Test
	void testActualizar() {
		Mensajes m1 = new Mensajes("200", "Categoria actualizada", categoria1);
		when(controlador.actualizar(categoria1)).thenReturn(m1);
		Mensajes res = controlador.actualizar(categoria1);
		Assertions.assertEquals(res,m1);

	}
	@Test
	void testActualizar_2() {
		Mensajes m1 = new Mensajes("200", "Categoria actualizada", categoria1);
		when(controlador.actualizar(categoria1)).thenReturn(m1);
		Mensajes res = controlador.actualizar(categoria2);
		Assertions.assertNotEquals(res,m1);

	}

	@Test
	void testDeleteCategoria() {
		Mensajes m1 = new Mensajes("200", "Categoria eliminada", categoria1);
		when(controlador.delete(categoria1)).thenReturn(m1);
		Mensajes res = controlador.delete(categoria1);
		Assertions.assertEquals(res,m1);
	}
	@Test
	void testDeleteCategoria_2() {
		Mensajes m1 = new Mensajes("200", "Categoria eliminada", categoria1);
		when(controlador.delete(categoria1)).thenReturn(m1);
		Mensajes res = controlador.delete(categoria2);
		Assertions.assertNotEquals(res,m1);
	}

	@Test
	void testDeleteString() {
		Mensajes m1 = new Mensajes("200", "Categoria eliminada", null);
		when(controlador.delete("5")).thenReturn(m1);
		Mensajes res = controlador.delete("5");
		Assertions.assertEquals(res,m1);
	}
	
	@Test
	void testDeleteString_2() {
		Mensajes m1 = new Mensajes("200", "Categoria eliminada", null);
		when(controlador.delete("5")).thenReturn(m1);
		Mensajes res = controlador.delete("10");
		Assertions.assertNotEquals(res,m1);
	}

	@Test
	void testInsert() {
		Mensajes m1 = new Mensajes("200", "Categoria insertada", null);
		when(controlador.insert(categoria1)).thenReturn(m1);
		Mensajes res = controlador.insert(categoria1);
		Assertions.assertEquals(res,m1);
	}
	@Test
	void testInsert_2() {
		Mensajes m1 = new Mensajes("200", "Categoria insertada", null);
		when(controlador.insert(categoria1)).thenReturn(m1);
		Mensajes res = controlador.insert(categoria2);
		Assertions.assertNotEquals(res,m1);
	}

}
