package com.estudo.pesquisa.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.estudo.pesquisa.entities.Host;
import com.estudo.pesquisa.repositories.HostRepository;
import com.estudo.pesquisa.services.exceptions.DatabaseException;
import com.estudo.pesquisa.services.exceptions.ResourceNotFoundException;

@Service
public class HostService {
	
	//12345
	
	@Autowired
	private HostRepository repository;
	
	public List<Host> findAll(){
		
		return repository.findAll();
		
	}
	
	public Host findById (String id) {
		
		Optional<Host> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		
	}
	
	public Host insert(Host obj) {
		return repository.save(obj);
	}
	
	public void delete(String id) {
		
		try {
		repository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Host update (String id, Host obj) {
		
	try {
		Host entity = repository.getById(id);
		updateData(entity, obj);
		
		return repository.save(entity);
	}catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException(id);
	}
	}

	
	  private void updateData(Host entity, Host obj) {
	  
	  entity.setChave(obj.getChave()); 
	  entity.setId(obj.getId());
	  
	  
	  }
	 

}
