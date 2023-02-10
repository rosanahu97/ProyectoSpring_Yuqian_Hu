package es.rf.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.service.IServicio;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

	@Autowired
	@Qualifier("ServicioUsuario")
	private IServicio cDao;
	

	@GetMapping
	public List<Usuario> leerTodos() {
		return cDao.leerTodos();

	}

	@GetMapping("/{id}")
	public Usuario leerUno(@PathVariable("id") Integer id) throws DAOException {
		return (Usuario) cDao.leerUno(id);

	}

	@PutMapping
	public String[] actualizar(@RequestBody Usuario usuario) throws DAOException {
		cDao.actualizar(usuario);
		return new String[] { "200", "Usuario actualizada" };
	}

	@DeleteMapping
	public String[] delete(Usuario usuario) throws DAOException {
		cDao.delete(usuario);
		return new String[] { "200", "Usuario eliminada" };
	}

	@DeleteMapping("/{id}")
	public String[] delete(@PathVariable("id") Integer usuario_id) throws DAOException {
		cDao.delete(usuario_id);		
		return new String[] { "200", "Usuario eliminada" };
	}

	@PostMapping
	public String[] insert(@RequestBody Usuario usuario) throws DAOException {
		usuario.setId_usuario(0);
		cDao.insert(usuario);
		return new String[] { "200", "Usuario insertada" };

	}

}
