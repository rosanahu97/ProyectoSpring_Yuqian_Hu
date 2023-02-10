package es.rf.tienda.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;

@Service
public interface IServicio<T,S,R> {
	
	
	public Map<R,T> leerUno(S s) throws DAOException ;	
	public List<T>leerTodos();
	public void actualizar(T t) throws DAOException; 
	public void delete(S s) throws DAOException ;
	public void insert(T t) throws DAOException;

}
