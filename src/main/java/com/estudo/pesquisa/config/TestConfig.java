package com.estudo.pesquisa.config;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudo.pesquisa.entities.Evento;
import com.estudo.pesquisa.entities.Host;
import com.estudo.pesquisa.entities.pk.EventoPK;
import com.estudo.pesquisa.repositories.EventoRepository;
import com.estudo.pesquisa.repositories.HostRepository;
import com.estudo.pesquisa.services.EventoService;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	//@Autowired
	//private HostRepository hostRepository;
	//@Autowired
	//private EventoRepository eventoRepository;
	
	//@Autowired
	//private EventoService ev; 

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Teste!");
		/*
		 * List<Host> hosts = hostRepository.findAll(); List<Evento>eventos =
		 * eventoRepository.findAll();
		 * 
		 * //for(Host h: hostRepository.findAll()) { System.out.println(h.getId() +
		 * " - " //+ h.getChave()); }
		 * 
		 * for(Host h: hostRepository.findAll()) { System.out.println(h.getId());}
		 * 
		 * 
		 * for(Evento h: eventoRepository.findAll()) {
		 * 
		 * System.out.println(h.getMensagem().substring(26,32));
		 * 
		 * }
		 * 
		 * System.out.println("DDDD");
		 * 
		 * String tmp="";
		 * 
		 * for(Evento eTmp:eventos) { for(Host hTmp: hosts) {
		 * if(hTmp.getId().equals(eTmp.getMensagem().substring(26,32))){
		 * tmp+=hTmp.getChave()+","; //System.out.println("\n" + hTmp.getChave());
		 * break; }
		 * 
		 * } }
		 * 
		 * System.out.println(tmp);
		 * 
		 * Optional <Evento> obj;
		 * 
		 * try { ev.findById(new EventoPK(430L,"21336",new
		 * SimpleDateFormat("yyyyMMdd").parse("20190701").toInstant()));
		 * 
		 * }catch(RuntimeException e) {
		 * 
		 * e.getMessage();
		 * 
		 * }
		 */
		//new SimpleDateFormat("yyyymmdd").parse(data).toInstant());
		///	
		//Instant tmp = new SimpleDateFormat("yyyyMMdd").parse("20150507").toInstant();
	
	
		//System.out.println(tmp.truncatedTo(ChronoUnit.DAYS));
		
		 //ZonedDateTime zonedDateTime = ZonedDateTime.parse("20150507", formatter);
		
		//Instant tmp = Instant.now();
		
			

			/*
			 * for(Evento t:ev.findByDataPeriodo("01072019", "01072019")) {
			 * System.out.println(t.getMensagem()); };
			 */
			
			
		
	}

}
