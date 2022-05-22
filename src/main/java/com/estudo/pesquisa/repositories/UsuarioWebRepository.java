package com.estudo.pesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.estudo.pesquisa.entities.UsuarioWeb;


public interface UsuarioWebRepository extends JpaRepository<UsuarioWeb, Long>{


@Transactional
@Modifying
@Query(value = "call restaura_usuarios()", nativeQuery = true)
//@Procedure(procedureName = "restaura_usuarios")
public void restauraUsuarios();	
	
	

}
