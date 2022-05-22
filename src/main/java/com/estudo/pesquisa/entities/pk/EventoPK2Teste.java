package com.estudo.pesquisa.entities.pk;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;



@Embeddable
public class EventoPK2Teste implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	private String nsx;
	
	private String data;

	
	public EventoPK2Teste() {
	}

	
	

	public EventoPK2Teste(Long idOrigem, String nsx, String data) {
		super();
		this.id = idOrigem;
		this.nsx = nsx;
		this.data = data;
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

	public void setNsx(String nsu) {
		this.nsx = nsu;
	}

	public String getData() {
		
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nsx == null) ? 0 : nsx.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventoPK2Teste other = (EventoPK2Teste) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nsx == null) {
			if (other.nsx != null)
				return false;
		} else if (!nsx.equals(other.nsx))
			return false;
		return true;
	}
	
	
	
	

}
