package com.estudo.pesquisa.entities.dto;







import com.estudo.pesquisa.entities.UsuarioWeb;

public class UsuarioWebDTO {
	private Long IDUSUARIO;
	private String senha;
	private String email;
	private String login;

	
	public UsuarioWebDTO(UsuarioWeb user){
		
		this.IDUSUARIO=user.getIdUsuario();
		this.login=user.getLogin();
		this.senha=user.getSenha();
		this.email=user.getEmail();
		
	}

	public Long getIDUSUARIO() {
		return IDUSUARIO;
	}
	public void setIDUSUARIO(Long iDUSUARIO) {
		IDUSUARIO = iDUSUARIO;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	

}
