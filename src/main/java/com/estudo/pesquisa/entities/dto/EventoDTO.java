package com.estudo.pesquisa.entities.dto;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//EM ESTUDO...
//@Entity
//@Table(name="evento")
public class EventoDTO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDORIGEM")
	private Long idOrigem;
	
	@Column(name="NSU")
	private String nsu;

	@Column(name="DATA")
	private Instant data;
	
	@Column(name="HORA")
	private Instant hora;
	
	@Column(name="TIPOMSG")
    private Integer tipoMsg;
	
	@Column(name="QTDE")
    private Integer qtde;
    
	@Column(name="MSG")
    private String msg;
    
	public EventoDTO() {
		
	}
	
	

	public EventoDTO(Long idOrigem, String nsu, Instant data, Instant hora, Integer tipoMsg, Integer qtde, String msg) {
		super();
		this.idOrigem = idOrigem;
		this.nsu = nsu;
		this.data = data;
		this.hora = hora;
		this.tipoMsg = tipoMsg;
		this.qtde = qtde;
		this.msg = msg;
	}



	public Long getIdOrigem() {
		return idOrigem;
	}

	public void setIdOrigem(Long idOrigem) {
		this.idOrigem = idOrigem;
	}

	public String getNsu() {
		return nsu;
	}

	public void setNsu(String nsu) {
		this.nsu = nsu;
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

	public Integer getTipoMsg() {
		return tipoMsg;
	}

	public void setTipoMsg(Integer tipoMsg) {
		this.tipoMsg = tipoMsg;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
