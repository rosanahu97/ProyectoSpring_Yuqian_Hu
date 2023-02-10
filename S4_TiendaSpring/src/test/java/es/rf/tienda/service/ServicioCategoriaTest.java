package es.rf.tienda.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.interfacesDaos.ICategoriaRepo;

class ServicioCategoriaTest {
	
	
	private ICategoriaRepo iCategoriaRepo; 
	
	private ServicioCategoria servicioCategoria;
	
	private Categoria categoria1;
	private Categoria categoria2;
	
	@BeforeEach
	void inicio() throws DomainException {
		iCategoriaRepo = mock(ICategoriaRepo.class);
		servicioCategoria = mock(ServicioCategoria.class);
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
	void testLeerUno() {
		when(servicioCategoria.leerUno(5)).thenReturn(categoria1);	
		Categoria res = servicioCategoria.leerUno(5);
		Assertions.assertEquals(res,categoria1);
	
	}

	@Test
	void testLeerUno_2() {
		when(servicioCategoria.leerUno(5)).thenReturn(categoria1);	
		Categoria res = servicioCategoria.leerUno(10);
		Assertions.assertNotEquals(res,categoria1);
	
	}
	@Test
	void testLeerTodos() {
		when(servicioCategoria.leerTodos()).thenReturn(List.of(categoria1,categoria2));
		List<Categoria> listaCat = servicioCategoria.leerTodos();
		Assertions.assertEquals(2,listaCat.size());
		
	}
	@Test
	void testLeerTodos_2() {
		when(servicioCategoria.leerTodos()).thenReturn(List.of(categoria1,categoria2));
		List<Categoria> listaCat = servicioCategoria.leerTodos();
		Assertions.assertNotEquals(1,listaCat.size());
		
	}

	
}
