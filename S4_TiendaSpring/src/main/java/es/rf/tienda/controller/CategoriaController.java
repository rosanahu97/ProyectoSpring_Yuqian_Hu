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
import es.rf.tienda.interfacesDaos.ICategoriaRepo;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

	@Autowired
	private ICategoriaRepo cDao;
	//cambiarlo por IServicioCategoria

	@GetMapping
	public List<Categoria> leerTodos() {
		return cDao.findAll();

	}

	@GetMapping("/{id}")
	public Categoria leerUno(@PathVariable("id") int id) {
		
		if(cDao.findById(id)==null) {
			throw new NullPointerException("Categoria no existe");
		}
		return cDao.findById(id).get();

	}

	@PutMapping
	public String[] actualizar(@RequestBody Categoria categoria) throws SQLException {
		int id = categoria.getId_categoria();
		
		if(cDao.findById(id)==null) {
			throw new NullPointerException("Categoria no existe");
		}
		
		cDao.save(categoria);
		return new String[] { "200", "Categoria actualizada" };
	}

	@DeleteMapping
	public String[] delete(Categoria categoria) throws SQLException {
		int id = categoria.getId_categoria();
		
		if(cDao.findById(id)==null) {
			throw new NullPointerException("Categoria no existe");
		}
		
		cDao.delete(categoria);
		return new String[] { "200", "Categoria eliminada" };
	}

	@DeleteMapping("/{id}")
	public String[] delete(@PathVariable("id") int categoria_id) throws SQLException {
		
		if(cDao.findById(categoria_id)==null) {
			throw new NullPointerException("Categoria no existe");
		}
			
		cDao.deleteById(categoria_id);
		return new String[] { "200", "Categoria eliminada" };
	}

	@PostMapping
	public String[] insert(@RequestBody Categoria categoria) throws SQLException {
		categoria.setId_categoria(0);
		cDao.save(categoria);
		return new String[] { "200", "Categoria insertada" };

	}

}
