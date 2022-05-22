package com.estudo.pesquisa.resources;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudo.pesquisa.entities.Evento;
import com.estudo.pesquisa.entities.pk.EventoPK;
import com.estudo.pesquisa.services.EventoService;



@RestController
@RequestMapping(value = "/eventos")
public class EventoResources {
	
	
	
	@Autowired
	private EventoService service;
	
	@GetMapping
	public ResponseEntity<List<Evento>> findAll(){
		
	List <Evento> list = service.findAll();
		
	return ResponseEntity.ok().body(list);
		
	}
	
	  @GetMapping(value = "/{id}/{nsx}/{data}")
	  public ResponseEntity<Evento> findById(@PathVariable Long id, @PathVariable String nsx,  @PathVariable  String data){
		  
	  		  
		  Evento obj = service.findById(new EventoPK(id,nsx,data));
	  
	  
	  return ResponseEntity.ok().body(obj);
	  }
	  

	  
	/*
	 * @PostMapping public ResponseEntity<Evento> insert(@RequestBody Evento obj){
	 * 
	 * obj = service.insert(obj);
	 * 
	 * URI uri =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (obj.getIdOrigem()).toUri();
	 * 
	 * return ResponseEntity.created(uri).body(obj);
	 * 
	 * }
	 */
	 /* 
	 * @DeleteMapping(value = "/{id}") public ResponseEntity<Void> delete
	 * (@PathVariable Long id){
	 * 
	 * service.delete(id); return ResponseEntity.noContent().build();
	 * 
	 * }
	 * 
	 * @PutMapping(value = "/{id}") public ResponseEntity<User> update(@PathVariable
	 * Long id, @RequestBody User obj){
	 * 
	 * obj = service.update(id, obj); return ResponseEntity.ok().body(obj);
	 * 
	 * }
	 */
	
	
	

}
