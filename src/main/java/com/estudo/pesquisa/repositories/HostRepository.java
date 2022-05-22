package com.estudo.pesquisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.pesquisa.entities.Host;



public interface HostRepository extends JpaRepository<Host, String>{
	
	

}
