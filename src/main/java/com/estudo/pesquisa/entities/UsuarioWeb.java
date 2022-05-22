package com.estudo.pesquisa.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="tb_webusuario")
public class UsuarioWeb implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	//@SequenceGenerator(name="my_seq_webusuario", sequenceName="SEQ_WEBUSUARIO", allocationSize = 1)//ORACLE
	//@GeneratedValue(strategy = GenerationType.AUTO, generator="my_seq_webusuario")//ORACLE
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDUSUARIO;
	private Long IDPAI;
	
	 @Column(name="pass")
	private String senha;
	
	 @Column(name="ESTADO")
	private Long estado;
	 
	 @Column(name="EMAIL")
	private String email;
	 
	 	 
	 @Column(name="LOGIN", unique=true, nullable=false)
	private String login;
		
	@Column(name="MAXSESSIONS")	
	
	private Integer maxSessions;
	private Instant DATACADASTRO;
	private Instant HORACADASTRO;
	private Instant DATAACESSO;
	private Instant HORAACESSO;
	
	@Column(name="IDPERFIL")
	private Integer idPerfil;
	
	public UsuarioWeb() {		
	}
	
	
	
	public UsuarioWeb(Long idUsuario, Long idPai, String login,String senha, Long estado, String email, Instant dataCadastro,
			Instant horaCadastro, Instant dataAcesso, Instant horaAcesso, Integer maxSessions, Integer idPerfil ) {
		super();
		this.IDUSUARIO = idUsuario;
		this.IDPAI = idPai;
		this.senha = senha;
		this.estado = estado;
		this.login = login;
		this.email = email;
		
		this.maxSessions = maxSessions;
		this.DATACADASTRO = dataCadastro;
		this.HORACADASTRO = horaCadastro;
		this.DATAACESSO = dataAcesso;
		this.HORAACESSO = horaAcesso;
		this.idPerfil = idPerfil;
	}



	public Long getIdUsuario() {
		return IDUSUARIO;
	}
	public void setIdUsuario(Long idUsuario) {
		this.IDUSUARIO = idUsuario;
	}
	public Long getIdPai() {
		return IDPAI;
	}
	public void setIdPai(Long idPai) {
		this.IDPAI = idPai;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getEstado() {
		return estado;
	}
	public void setEstado(Long estado) {
		this.estado = estado;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Instant getDataCadastro() {
		return DATACADASTRO;
	}
	public void setDataCadastro(Instant dataCadastro) {
		this.DATACADASTRO = dataCadastro;
	}
	public Instant getHoraCadastro() {
		return HORACADASTRO;
	}
	public void setHoraCadastro(Instant horaCadastro) {
		this.HORACADASTRO = horaCadastro;
	}
	public Instant getDataAcesso() {
		return DATAACESSO;
	}
	public void setDataAcesso(Instant dataAcesso) {
		this.DATAACESSO = dataAcesso;
	}
	public Instant getHoraAcesso() {
		return HORAACESSO;
	}
	public void setHoraAcesso(Instant horaAcesso) {
		this.HORAACESSO = horaAcesso;
	}
	
	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer perfil) {
		this.idPerfil = perfil;
	}

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	

	public Integer getMaxSessions() {
		return maxSessions;
	}



	public void setMaxSessions(Integer maxSessions) {
		this.maxSessions = maxSessions;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IDUSUARIO == null) ? 0 : IDUSUARIO.hashCode());
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
		UsuarioWeb other = (UsuarioWeb) obj;
		if (IDUSUARIO == null) {
			if (other.IDUSUARIO != null)
				return false;
		} else if (!IDUSUARIO.equals(other.IDUSUARIO))
			return false;
		return true;
	}
	
	

}
