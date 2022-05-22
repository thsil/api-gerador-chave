package com.estudo.pesquisa.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.estudo.pesquisa.entities.UsuarioWeb;
import com.estudo.pesquisa.entities.dto.UsuarioWebDTO;
import com.estudo.pesquisa.services.UsuarioWebService;

@RestController
@RequestMapping(value = "/users")
public class UsuarioWebResources {
	
	@Autowired
	private UsuarioWebService service;
	
	@GetMapping
	public ResponseEntity<List<UsuarioWebDTO>> findAll(){
		
	List <UsuarioWebDTO> list = service.findAll();
		
	return ResponseEntity.ok().body(list);
		
	}
	
	  @GetMapping(value = "/{id}") public ResponseEntity<UsuarioWeb>
	  findById(@PathVariable Long id){ UsuarioWeb obj = service.findById(id);
	  
	    
	  return ResponseEntity.ok().body(obj); }
	  
	  @PostMapping 
	  public ResponseEntity<UsuarioWeb> insert(@RequestBody UsuarioWeb obj){
		  
  
	  obj = service.insert(obj);
	  
	  URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUsuario()).toUri();
	  
	  return ResponseEntity.created(uri).body(obj);
	  
	  }
	  
	  @DeleteMapping(value = "/{id}") 
	  public ResponseEntity<Void> delete(@PathVariable Long id){
	  
	  service.delete(id); return ResponseEntity.noContent().build();
	  
	  }
	  
	  @PutMapping(value = "/{id}") 
	  public ResponseEntity<UsuarioWeb> update(@PathVariable Long id, @RequestBody UsuarioWeb obj){
	  
	  obj = service.update(id, obj); return ResponseEntity.ok().body(obj);
	  
	  }
	  
	  
	   @GetMapping(value="/restaura_tabela_usuarios")	   
		//public String restauraUsuarios(){
		   public ResponseEntity<String> restauraUsuarios(){
		
		   
		   
		   
		service.restauraUsuarios();
			
		
		return ResponseEntity.ok().body("USUARIOS RESTAURADOS!");		
		//return "USUARIOS RESTAURADOS!";
			
		}
	 
	
	
	

}
