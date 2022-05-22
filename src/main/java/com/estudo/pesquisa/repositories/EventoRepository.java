package com.estudo.pesquisa.repositories;



import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estudo.pesquisa.entities.Evento;
import com.estudo.pesquisa.entities.pk.EventoPK;

@Repository
public interface EventoRepository extends JpaRepository<Evento, EventoPK>{
	
	
	//select * from tb_evento2 where to_date(data,'yyyymmdd') between to_date('20110507','yyyymmdd') and to_date('20300507','yyyymmdd');
	@Query(value="select * from tb_evento e where to_date(e.data,'yyyymmdd') between to_date(?1,'yyyymmdd') and to_date(?2, 'yyyymmdd')", nativeQuery=true)
	List <Evento> findByDataPeriodo(String datainicio, String datafim);
	 
	 //@Query("select e from Evento e where e.data = '2015-05-07 12:05:00'")
	// @Query("select e from Evento e where date_trunc('day',e.data) = ?1")
	//Evento findTesteId(Date data);
	 
	// @Query("select e from Evento e where e.id = ?1 and e.nsx = ?2 and date_trunc('day',e.data) = ?3")
	//	Evento findIdCustom(Long id, String nsx, Date data);
	 
	 //@Query("select e from Evento e where e.id = ?1 and e.nsx = ?2 and data = ?3")
		//Evento findTesteId(Long id, String nsx, Instant data);
	
	 //@Query("select e from Evento e where e.data >= ?1 and e.data <= ?2")
	 //List<Evento> findByDataPeriodo(String dataFim, String dataInicio);
	
}
