package com.estudo.pesquisa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.estudo.pesquisa.entities.Evento;
import com.estudo.pesquisa.entities.Host;
import com.estudo.pesquisa.entities.UsuarioWeb;
import com.estudo.pesquisa.services.exceptions.ResourceDateNotFoundException;
import com.estudo.pesquisa.services.exceptions.ResourceNotFoundException;

@Service
public class GeraChaveService {
	
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private HostService hostService;
	
	@Autowired
	private UsuarioWebService usuarioWebService;
	
	
		
	public Host geraChave(String dataInicio, String dataFim, String host, Long id) {
		
		
		Optional<Host> hostTmp = Optional.ofNullable(hostService.findById(host));
		
		Optional<UsuarioWeb> userTmp = Optional.ofNullable(usuarioWebService.findById(id));
		
		
		if(hostTmp.isEmpty()||userTmp.isEmpty()) {
			throw new ResourceNotFoundException(host);
		}
		
		System.out.println(dataInicio + " - " +dataFim);
		
		List<Evento>eventos = eventoService.findByDataPeriodo(dataInicio,dataFim);
		
		System.out.println(eventos);
		
		if(eventos.isEmpty()) {
			throw new ResourceDateNotFoundException(dataInicio+"/"+dataFim);
		}
		
		
		for(Evento eTmp:eventos) {
			
			if(hostTmp.get().getId().equals(eTmp.getMensagem().substring(26,32))){
				return hostTmp.orElseThrow(() -> new ResourceDateNotFoundException(host));
			}
			
			
		}
		//return ResponseEntity.noContent().build();
		throw new ResourceNotFoundException(host);
		
	}
	


}
