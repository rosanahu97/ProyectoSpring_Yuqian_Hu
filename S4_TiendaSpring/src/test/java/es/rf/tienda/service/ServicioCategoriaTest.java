package es.rf.tienda.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.interfacesDaos.ICategoriaRepo;

class ServicioCategoriaTest {
	
	@Mock
	private ICategoriaRepo iCategoriaRepo; 
	@InjectMocks
	private ServicioCategoria servicioCategoria;
	
	private Categoria categoria;
	
	@BeforeEach
	void inicio() throws DomainException {
		categoria = new Categoria();
		categoria.setId_categoria(5);
		categoria.setCat_nombre("Normal");
		categoria.setCat_descripcion("Descripcion categoria");
	}
	
	
	@Test
	void testLeerUno() {

	}

	@Test
	void testLeerTodos() {
		fail("Not yet implemented");
	}

	@Test
	void testActualizar() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteCategoria() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteInt() {
		fail("Not yet implemented");
	}

	@Test
	void testInsert() {
		fail("Not yet implemented");
	}

}
