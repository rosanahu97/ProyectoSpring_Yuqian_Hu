package es.rf.tienda.interfacesDaos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Categoria;

public interface ICategoriaRepo extends JpaRepository<Categoria,Integer> {
	
}
