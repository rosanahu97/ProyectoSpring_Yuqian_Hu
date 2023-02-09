package es.rf.tienda.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;

@Service
public interface IServicioCategoria {
	public Categoria leerUno(int id) throws DAOException ;
	
	public List<Categoria>leerTodos();
	public void actualizar(Categoria categoria) throws DAOException; 
	public void delete(Categoria categoria) throws DAOException ; 
	public void delete( int categoria_id) throws DAOException ;
	public void insert(Categoria categoria) throws DAOException;

}
