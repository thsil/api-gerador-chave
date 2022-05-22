package com.estudo.pesquisa.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.estudo.pesquisa.entities.UsuarioWeb;
import com.estudo.pesquisa.entities.dto.UsuarioWebDTO;
import com.estudo.pesquisa.repositories.UsuarioWebRepository;
import com.estudo.pesquisa.services.exceptions.DatabaseException;
import com.estudo.pesquisa.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioWebService {
	
	//12345
	
	@Autowired
	private UsuarioWebRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<UsuarioWebDTO> findAll(){
		
		//return repository.findAll();
		
		return repository.findAll().stream().map(UsuarioWebDTO::new).collect(Collectors.toList()); 
		
	}
	
	public void restauraUsuarios() {
		
		repository.restauraUsuarios();
		
	}
	
	public UsuarioWeb findById (Long id) {
		
		Optional<UsuarioWeb> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		
	}
	
	public UsuarioWeb insert(UsuarioWeb obj) {
		
//		if(obj.getIdUsuario()!=null) {
//			throw new ResourceNotFoundException(obj);
//		}
		
		
		obj.setSenha(passwordEncoder.encode(obj.getSenha()));
		obj.setDataCadastro(Instant.now());
		obj.setHoraCadastro(Instant.now());
		obj.setDataAcesso(Instant.now());
		obj.setHoraAcesso(Instant.now());
			
		

		try {
		return repository.save(obj);
		} catch( DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}catch (ConstraintViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public void delete(Long id) {
		
		try {
		repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public UsuarioWeb update (Long id, UsuarioWeb obj) {
		
	try {
		UsuarioWeb entity = repository.getById(id);
		updateData(entity, obj);
		
		return repository.save(entity);
	}catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException(id);
	}catch (DataIntegrityViolationException e) {
		
		throw new DatabaseException(e.getMessage());
	}
	}

	
	  private void updateData(UsuarioWeb entity, UsuarioWeb obj) {
		  
	  	  
	  
	  
	
		  
		  entity.setMaxSessions(obj.getMaxSessions());
		  
		  if(obj.getSenha()!=null){
			  entity.setSenha(passwordEncoder.encode(obj.getSenha()));  
		  }
	      
		    
	      entity.setLogin(obj.getLogin()); 
		  entity.setEmail(obj.getEmail());
  
	  
	  
	  }
	 

}
