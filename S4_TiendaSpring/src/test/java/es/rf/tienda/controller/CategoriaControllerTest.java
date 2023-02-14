package es.rf.tienda.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Mensajes;

class CategoriaControllerTest {

	private CategoriaController controlador;

	private Categoria categoria1;
	private Categoria categoria2;
	private Categoria categoria3;
	private Map<String, Object> map_error;
	private Map<String, Object> map;


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
		map= new LinkedHashMap<String, Object>();
		map.put("Estado", 200);
		map.put("Mensaje", "");
		map.put("Categoria", categoria1);
		when(controlador.leerUno("5")).thenReturn(map);	
		Assertions.assertEquals(map,controlador.leerUno("5"));
	}
	@Test
	void testLeerUno_2() {
		map= new LinkedHashMap<String, Object>();
		map.put("Estado", 200);
		map.put("Mensaje", "");
		map.put("Categoria", categoria1);
		when(controlador.leerUno("5")).thenReturn(map);	
		Assertions.assertNotEquals(controlador.leerUno("10"),map);
	}
	
	@Test
	void testLeerUno_Exception() {
		map_error= new LinkedHashMap<String, Object>();
		map_error.put("Estado", 500);
		map_error.put("Mensaje", "Categoria no existe");
		map_error.put("Categoria", null);
		when(controlador.leerUno("90")).thenReturn(map_error);	
		Assertions.assertEquals(controlador.leerUno("90"),map_error);
	
	}
	
	
	
	@Test
	void testActualizar() {
		map= new LinkedHashMap<String, Object>();
		map.put("Estado", 200);
		map.put("Mensaje", "Categoria actualizada");
		map.put("Categoria", categoria1);
		when(controlador.actualizar(categoria1)).thenReturn(map);
		Assertions.assertEquals(controlador.actualizar(categoria1),map);

	}
	
	
	@Test
	void testActualizar_Exception() {
		map_error= new LinkedHashMap<String, Object>();
		map_error.put("Estado", 500);
		map_error.put("Mensaje", "Error actualizacion");
		map_error.put("Categoria", null);
		when(controlador.actualizar(categoria3)).thenReturn(map_error);	
		Assertions.assertEquals(controlador.actualizar(categoria3),map_error);
	}
	
	@Test
	void testActualizar_2() {
		map= new LinkedHashMap<String, Object>();
		map.put("Estado", 200);
		map.put("Mensaje", "Categoria actualizada");
		map.put("Categoria", categoria1);
		when(controlador.actualizar(categoria1)).thenReturn(map);
		Assertions.assertNotEquals(controlador.actualizar(categoria2),map);

	}

	@Test
	void testDeleteCategoriaById() {
		map= new LinkedHashMap<String, Object>();
		map.put("Estado", 200);
		map.put("Mensaje", "Categoria eliminada");
		map.put("Categoria", categoria1);
		when(controlador.delete("5")).thenReturn(map);
		Assertions.assertEquals(controlador.delete("5"),map);
	}
	@Test
	void testDeleteCategoriaById_2() {
		map= new LinkedHashMap<String, Object>();
		map.put("Estado", 200);
		map.put("Mensaje", "Categoria eliminada");
		map.put("Categoria", categoria1);
		when(controlador.delete("10")).thenReturn(map);
		Assertions.assertNotEquals(controlador.delete("5"),map);
	}

	
	@Test
	void testInsert() {
		map= new LinkedHashMap<String, Object>();
		map.put("Estado", 200);
		map.put("Mensaje", "Categoria insertada");
		map.put("Categoria", null);
		when(controlador.insert(categoria1)).thenReturn(map);
		Assertions.assertEquals(controlador.insert(categoria1),map);
	}
	@Test
	void testInsert_2() {
		map= new LinkedHashMap<String, Object>();
		map.put("Estado", 200);
		map.put("Mensaje", "Categoria insertada");
		map.put("Categoria", null);
		when(controlador.insert(categoria1)).thenReturn(map);
	
		Assertions.assertNotEquals(controlador.insert(categoria2),map);
	}
	

}
