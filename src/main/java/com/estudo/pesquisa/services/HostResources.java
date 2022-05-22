package com.estudo.pesquisa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.pesquisa.entities.Host;

@RestController
@RequestMapping(value = "/hosts")
public class HostResources {
	
	@Autowired
	private HostService service;
	
	@GetMapping
	public ResponseEntity<List<Host>> findAll(){
		
	List <Host> list = service.findAll();
		
	return ResponseEntity.ok().body(list);
		
	}

}
