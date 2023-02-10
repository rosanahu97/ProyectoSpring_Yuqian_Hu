package es.rf.tienda.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.interfacesDaos.ICategoriaRepo;

@Service
@Component("ServicioCategoria")
public class ServicioCategoria implements IServicio<Categoria,Integer,String> {
	
	@Autowired
	private ICategoriaRepo cDao;
	
	public Map<String,Categoria> leerUno(Integer id) throws DAOException {
		Map<String,Categoria>map = new HashMap<>();
		Categoria res = null;
		try {	
			res =cDao.findById(id).get();
			map.put("Datos", res);
			return map;

		}catch(IllegalArgumentException e) {
			map.put("Error", res);
			return map;
		}catch(NoSuchElementException e) {
			map.put("Error", res);

			return map;

		}
		
		
		
	}
	
	public List<Categoria>leerTodos(){
		return cDao.findAll();
		
	}

	public void actualizar(Categoria categoria) throws DAOException  {
		if(categoria.isValidaUpdate()) {
			try {
				cDao.save(categoria);
				
			}catch(NoSuchElementException e) {
				throw new DAOException("No existe categoria con id: "+categoria.getId_categoria());
			}
		}
	}

	public void delete(Categoria categoria) throws DAOException  {
		
		try {	
			cDao.delete(categoria);
		}catch(IllegalArgumentException e) {
			throw new DAOException("Id nulo");
		}catch(NoSuchElementException e) {
			throw new DAOException("No existe categoria con id: "+categoria.getId_categoria());
		}
	}

	public void delete(Integer categoria_id) throws DAOException  {
		
		try {	
			cDao.deleteById(categoria_id);
		}catch(IllegalArgumentException e) {
			throw new DAOException("Id nulo");
		}catch(NoSuchElementException e) {
			throw new DAOException("No existe categoria con id: "+categoria_id);
		}
		
	}

	public void insert(Categoria categoria) throws DAOException {
		
		if(categoria.isValidaInsert()) {
			try {
				cDao.save(categoria);				
			}catch(IllegalArgumentException e) {
				throw new DAOException("Parametros incorrecto: "+categoria.getId_categoria());
			}
		}
	}



}
