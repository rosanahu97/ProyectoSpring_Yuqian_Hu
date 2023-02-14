package es.rf.tienda.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.rf.tienda.exception.DomainException;

class CategoriaTest {
	
	private Categoria categoria;
	final static int ID = 5;
	final static int ID_ERROR=0;
	final static String NOMBRE="ROSANA";
	final static String NOMBRE_ERROR ="HU";
	final static String NOMBRE_ERROR_2 ="";
	final static String DESCRIPCION ="UNA DESCRPCION CORRECTA";
	final static String DESCRIPCION_NULL="";
	
	@BeforeEach
	void inicio() {
		categoria = new Categoria();
	}
	
	@Test
	void testSetId_categoria() {
		categoria.setId_categoria(ID);
		Assertions.assertEquals(categoria.getId_categoria(), ID);
	}
	

	@Test
	void testSetCat_nombre() throws DomainException {
		categoria.setCat_nombre(NOMBRE);
		Assertions.assertEquals(categoria.getCat_nombre(), NOMBRE);
	}
	@Test
	void testSetCat_nombre_error() throws DomainException {
		Assertions.assertThrows(DomainException.class, ()->	categoria.setCat_nombre(NOMBRE_ERROR));
	}
	

	@Test
	void testSetCat_descripcion() throws DomainException {
		categoria.setCat_descripcion(DESCRIPCION);
		Assertions.assertEquals(categoria.getCat_descripcion(), DESCRIPCION);

	}
	@Test
	void testSetCat_descripcion_null()  {
		categoria.setCat_descripcion(DESCRIPCION_NULL);
		Assertions.assertEquals(categoria.getCat_descripcion(), DESCRIPCION_NULL);	}

	@Test
	void testIsValidaInsert() {
		categoria.setCat_nombre(NOMBRE);
		Assertions.assertTrue(categoria.isValidaInsert());
	}
	
	
	@Test
	void testIsValidaUpdate()  {
		categoria.setId_categoria(ID);
		categoria.setCat_nombre(NOMBRE);
		Assertions.assertTrue(categoria.isValidaUpdate());

	}
	@Test
	void testIsValidaUpdate_Error() {
		categoria.setId_categoria(ID_ERROR);
		categoria.setCat_nombre(NOMBRE);
		Assertions.assertFalse(categoria.isValidaUpdate());

	}

}
