package com.gestion.vehiculos.service;

import com.gestion.vehiculos.Entity.Usuarios;

public interface UsuarioService {
	
	public Usuarios crearUsuario(Usuarios usuario) throws Exception;
	public Usuarios actualizarUsuario(Usuarios usuario) throws Exception;
	public Usuarios buscarUsuarioPorUsuarioYContraseña(String username, String password) throws Exception;

}
