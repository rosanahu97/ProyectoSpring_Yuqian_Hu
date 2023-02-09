package es.rf.tienda.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfacesDaos.ICategoriaRepo;
import es.rf.tienda.service.IServicioCategoria;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

	@Autowired
	private IServicioCategoria cDao;
	

	@GetMapping
	public List<Categoria> leerTodos() {
		return cDao.leerTodos();

	}

	@GetMapping("/{id}")
	public Categoria leerUno(@PathVariable("id") int id) throws DAOException {
		return cDao.leerUno(id);

	}

	@PutMapping
	public String[] actualizar(@RequestBody Categoria categoria) throws DAOException {
		cDao.actualizar(categoria);
		return new String[] { "200", "Categoria actualizada" };
	}

	@DeleteMapping
	public String[] delete(Categoria categoria) throws DAOException {
		cDao.delete(categoria);
		return new String[] { "200", "Categoria eliminada" };
	}

	@DeleteMapping("/{id}")
	public String[] delete(@PathVariable("id") int categoria_id) throws DAOException {
		cDao.delete(categoria_id);		
		return new String[] { "200", "Categoria eliminada" };
	}

	@PostMapping
	public String[] insert(@RequestBody Categoria categoria) throws DAOException {
		categoria.setId_categoria(0);
		cDao.insert(categoria);
		return new String[] { "200", "Categoria insertada" };

	}

}
