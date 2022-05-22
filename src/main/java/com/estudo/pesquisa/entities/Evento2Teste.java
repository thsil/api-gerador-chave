package com.estudo.pesquisa.entities;

import java.time.Instant;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.estudo.pesquisa.entities.pk.EventoPK;
import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="tb_evento")
@IdClass(value=EventoPK.class)
public class Evento2Teste {
	
	
		
	
	  @Id	  
	  @Column(name="ID") private Long id;
	  
	  @Id	  
	  @Column(name="NSX") private String nsx;
	  
	  @Id	  
	 @Column(name = "data", columnDefinition = "DATE")
	  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd", timezone = "GMT") 
	  private Instant data;
	 

	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HHmmss", timezone = "GMT")
	@Column(name="HORA")
	private Instant hora;
	
	@Column(name="QTDE")
    private Integer qtde;
    
	@Column(name="MENSAGEM")
    private String mensagem;
    
	public Evento2Teste() {
		
	}
	
	

	public Evento2Teste(Long idOrigem, String nsu, Instant data, Instant hora, Integer tipoMsg, Integer qtde, String msg) {
		super();
		this.id = idOrigem;
		this.nsx = nsu;
		this.data = data;
		this.hora = hora;
		this.qtde = qtde;
		this.mensagem = msg;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNsx() {
		return nsx;
	}

	public void setNsx(String nsx) {
		this.nsx = nsx;
	}

	public Instant getData() {
	
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Instant getHora() {
		return hora;
	}

	public void setHora(Instant hora) {
		this.hora = hora;
	}


	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String msg) {
		this.mensagem = msg;
	}
	
	
	
}
