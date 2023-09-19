package com.gestion.vehiculos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.vehiculos.Entity.UsuarioRol;
import com.gestion.vehiculos.Entity.Usuarios;
import com.gestion.vehiculos.Repository.RolRepository;
import com.gestion.vehiculos.Repository.UsuarioRepository;
import com.gestion.vehiculos.service.UsuarioService;

@Service
public class UsuarioServicesImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
    @Autowired
    private RolRepository rolRepository;

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

	@Override
	public Usuarios crearUsuario(Usuarios usuario, List<UsuarioRol> usuarioRoles) throws Exception {
        Usuarios usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }
        else{
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
	}

}
