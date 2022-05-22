package com.estudo.pesquisa.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.estudo.pesquisa.entities.Evento;
import com.estudo.pesquisa.entities.pk.EventoPK;
import com.estudo.pesquisa.repositories.EventoRepository;
import com.estudo.pesquisa.services.exceptions.DatabaseException;
import com.estudo.pesquisa.services.exceptions.InvalidFormatDateException;
import com.estudo.pesquisa.services.exceptions.ResourceNotFoundException;

@Service
public class EventoService {


	@Autowired
	private EventoRepository repository;

	public List<Evento> findAll() {

		return repository.findAll();

	}

	public Evento findById(EventoPK id) {		
		
				
		Optional<Evento> obj = repository.findById(id);
			
	
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));

	}
	
	



	
	  public List<Evento> findByDataPeriodo(String dataInicio, String dataFim) {
	  List<Evento> obj=null; 
	  
	  	  
	  try {
		  obj = repository.findByDataPeriodo(dataInicio, dataFim);
	  }catch(DataIntegrityViolationException e) {
		  
		  throw new InvalidFormatDateException(e);
		  
	  }
		   
	     //obj = repository.findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(new SimpleDateFormat("ddMMyyyy").parse(dataInicio).toInstant(), new SimpleDateFormat("ddMMyyyy").parse(dataFim).toInstant());
	  
	  return obj; 
	  
	  }
	 

	public Evento insert(Evento obj) {
		return repository.save(obj);
	}

	public void delete(EventoPK id) {

		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Evento update(EventoPK id, Evento obj) {

		try {
			Evento entity = repository.getById(id);
			updateData(entity, obj);

			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Evento entity, Evento obj) {

		entity.setId(obj.getId());
		entity.setMensagem(obj.getMensagem());

	}

}
