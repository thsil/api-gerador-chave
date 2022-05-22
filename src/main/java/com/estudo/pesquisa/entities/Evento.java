package com.estudo.pesquisa.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.estudo.pesquisa.entities.pk.EventoPK;

@Entity
@Table(name="tb_evento")
public class Evento {
		
	@EmbeddedId	
	private EventoPK id;
	
	@Column(name="HORA", length=6)
	private String hora;
	
	@Column(name="QTDE")
    private Integer qtde;
    
	@Column(name="MENSAGEM")
    private String mensagem;
    
	public Evento() {
		
	}

	public Evento(EventoPK id, String hora, Integer qtde, String mensagem) {
		super();
		this.id = id;
		this.hora = hora;
		this.qtde = qtde;
		this.mensagem = mensagem;
	}

	public EventoPK getId() {
		return id;
	}

	public void setId(EventoPK id) {
		this.id = id;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
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

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
		
	
}
