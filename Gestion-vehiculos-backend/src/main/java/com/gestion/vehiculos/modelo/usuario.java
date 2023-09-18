package com.gestion.vehiculos.modelo;

public class usuario {

	private String mensaje;
	private String username;
	private String password;
	private String token;

	public usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public usuario(String username, String password, String token) {
		super();
		this.username = username;
		this.password = password;
		this.token = token;
		this.mensaje = mensaje;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
