package es.rf.tienda.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
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
import es.rf.tienda.service.IServicio;
import es.rf.tienda.util.Mensajes;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {

	@Autowired
	@Qualifier("ServicioCategoria")
	private IServicio cDao;

	@GetMapping
	public List<Categoria> leerTodos() {
		return cDao.leerTodos();

	}

	@GetMapping("/{id}")
	public Map<String, Object> leerUno(@PathVariable("id") String id) {
		if (id != null) {
			// si el id no es nulo
			try {
				int id_numeric = Integer.parseInt(id);
				Categoria cat = (Categoria) cDao.leerUno(id_numeric);
				// si no existe categoria con id id_numeric devuelve un mensaje de error
				if (cat == null) {
					return montaMensaje("500", "Categoria" + id_numeric + "no existe",null);
					// en caso contrario devuelve el objeto con codigo 200
				} else {
					return montaMensaje("200", "", cat);
				}
				// si el id contiene caracteres, devuelve un mensaje de error
			} catch (NumberFormatException e) {
				return montaMensaje("500", "Id categoria formato incorrecto",null);
			}
		} else {
			// si el id es nulo
			return montaMensaje("500", "Id nulo", null);
		}

	}

	@PutMapping
	public Map<String, Object> actualizar(@RequestBody Categoria categoria) {
		try {
			cDao.actualizar(categoria);
			return montaMensaje("200", "Categoria actualizada", categoria);

		} catch (DAOException e) {
			return montaMensaje("500", "Error actualizacion", null);

		}
	}


	@DeleteMapping("/{id}")
	public Map<String, Object> delete(@PathVariable("id") String categoria_id) {
		if (categoria_id != null) {
			// si el id no es nulo
			try {
				int id_numeric = Integer.parseInt(categoria_id);
				cDao.delete(id_numeric);
				return montaMensaje("200", "Categoria eliminada", null);
				// si el id contiene caracteres, devuelve un mensaje de error
			} catch (NumberFormatException e) {
				return montaMensaje("500", "Id categoria formato incorrecto", null);
				// si no existe categoria con id id_numeric devuelve un mensaje de error
			} catch (DAOException e) {
				return montaMensaje("500", "Categoria no existe", null);
			} 
		} else {
			// si el id es nulo
			return montaMensaje("500", "Id nulo", null);
		}

	}

	@PostMapping
	public Map<String, Object> insert(@RequestBody Categoria categoria){
		categoria.setId_categoria(0);
		try {
			cDao.insert(categoria);
			return montaMensaje("200", "Categoria insertada", null);

		} catch (DAOException e) {
			return montaMensaje("500", "Error insertar categoria", null);

		}

	}
	
	private Map<String, Object> montaMensaje(String codi, String mensaje,Categoria cat) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.clear();
		map.put("Estado", codi);
		map.put("Mensaje", mensaje);
		map.put("Categoria", cat);
		return map;
	}

}
