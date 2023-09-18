package com.gestion.vehiculos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.vehiculos.Entity.Usuarios;
import com.gestion.vehiculos.Repository.UsuarioRepository;
import com.gestion.vehiculos.service.UsuarioService;

@Service
public class UsuarioServicesImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuarios crearUsuario(Usuarios usuario) throws Exception {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuarios actualizarUsuario(Usuarios usuario) throws Exception {
		return usuarioRepository.saveAndFlush(usuario);
	}

	@Override
	public Usuarios buscarUsuarioPorUsuarioYContraseña(String username, String password) throws Exception {
		return usuarioRepository.findByUsernameAndPasswordUsuarios(username, password);
	}

}
