package es.rf.tienda.interfacesDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import es.rf.tienda.dominio.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario,Integer>{

}
