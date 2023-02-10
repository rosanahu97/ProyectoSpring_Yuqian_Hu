package es.rf.tienda.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Usuario;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfacesDaos.IUsuarioRepo;


@Service
@Component("ServicioUsuario")
public class ServicioUsuario implements IServicio<Usuario,Integer,String>{

	@Autowired
	private IUsuarioRepo cDao;
	
	public Map<String,Usuario> leerUno(Integer id) throws DAOException {
		Map<String,Usuario> map = new HashMap<String,Usuario>();
		Usuario res = null;
		try {	
			res =cDao.findById(id).get();
		}catch(IllegalArgumentException e) {
			throw new DAOException("Id nulo");
		}catch(NoSuchElementException e) {
			throw new DAOException("No existe categoria con id: "+id);
		}
		return map;
		
	}
	
	public List<Usuario>leerTodos(){
		return cDao.findAll();
		
	}

	public void actualizar(Usuario usuario) throws DAOException  {
		
			try {
				cDao.save(usuario);
				
			}catch(NoSuchElementException e) {
				throw new DAOException("No existe usuario con id: "+usuario.getId_usuario());
			}
		}
	

	public void delete(Usuario usuario) throws DAOException  {
		
		try {	
			cDao.delete(usuario);
		}catch(IllegalArgumentException e) {
			throw new DAOException("Id nulo");
		}catch(NoSuchElementException e) {
			throw new DAOException("No existe usuario con id: "+usuario.getId_usuario());
		}
	}

	public void delete(Integer usuario_id) throws DAOException  {
		
		try {	
			cDao.deleteById(usuario_id);
		}catch(IllegalArgumentException e) {
			throw new DAOException("Id nulo");
		}catch(NoSuchElementException e) {
			throw new DAOException("No existe usuariocon id: "+usuario_id);
		}
		
	}

	public void insert(Usuario usuario) throws DAOException {	
			try {
				cDao.save(usuario);				
			}catch(IllegalArgumentException e) {
				throw new DAOException("Parametros incorrecto: "+usuario.getId_usuario());
			}
		}
	



}
