package com.estudo.pesquisa.resources;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import com.estudo.pesquisa.entities.Host;
import com.estudo.pesquisa.entities.pk.EventoPK;
import com.estudo.pesquisa.services.EventoService;
import com.estudo.pesquisa.services.GeraChaveService;



@RestController
@RequestMapping(value = "/gerarchave")
public class GeradorChaves {
	
	
	
	@Autowired
	private GeraChaveService geraChaveService;
	
	
	/*
	 * @GetMapping public ResponseEntity<List<Evento>> findAll(){
	 * 
	 * List <Evento> list = eventoService.findAll();
	 * 
	 * return ResponseEntity.ok().body(list);
	 * 
	 * }
	 */
	/*
	 * A GERAÇÃO DO CHAVE É FEITA COM BASE NO HOST EXECUTANDO UM SCRIPT EM UM SERVIDOR LINUX,
	 * PARA ISSO FOI CRIADO UM APLICAÇÃO QUE FAZ O ACESSO E A EXECUÇÃO DO SCRIPT VIA SSH COM 
	 * CHAVE USO DE CHAVES PUBLICA/PRIVADA, PORÉM, PARA EFEITO DE TESTE ESTA INFORMAÇÃO FOI 
	 * INPUTADA DIRETAMENTE NO BANCO, ALÉM DISSO, ESSA CONSULTA SO É FEITA CASO O USUÁRIO EXISTA
	 * NO ARQUIVO GROUP, LEMBRANDO ESTA PARAMETRO AINDA NÃO FOI IMPLEMENTANDO NA CHAMADA DO ENDPOINT
	 */
	
	  @GetMapping(value = "/{dataInicio}/{dataFim}/{host}/{idUsuario}")
	  //@GetMapping(value = "/{dataInicio}/{dataFim}")
	  public ResponseEntity<Host> findByData(@PathVariable String dataInicio,  @PathVariable  String dataFim, @PathVariable String host, @PathVariable Long idUsuario){
		  
		  
		 
		  //Calendar c = Calendar.getInstance();
		  //c.setTime(new SimpleDateFormat("ddMMyyyy").parse(data));
		  
		  
		  //System.out.println(id + " - "+nsu +" - " +Instant.parse(data).truncatedTo(ChronoUnit.DAYS));
		  
		  //List<Evento> obj = service.findByData(dataInicio, dataFim);
		  
		
			 Host obj = geraChaveService.geraChave(dataInicio, dataFim, host, idUsuario);  
		
		  
		  
		  
		  //Evento obj = service.findById(new EventoPK(id,nsu,  c));
		  
		  //Calendar.getInstance()
	  
	  
	  
	  return ResponseEntity.ok().body(obj);
	  }
	  
	
	

}
