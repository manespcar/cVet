package com.spain.cvet.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spain.cvet.model.Usuarios;
import com.spain.cvet.repositories.UsuariosRepository;
import com.spain.cvet.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService {
	
	@Autowired
	private UsuariosRepository usuariosRepository;

	@Override
	public Usuarios getUserById(Integer id) {
		return usuariosRepository.getOne(id);
	}

	@Override
	public Usuarios saveUser(Usuarios usuario) {
		Usuarios usuarioBBDD = usuariosRepository.getOne(usuario.getId());
		usuario.setFechaCambio(new Date());
		usuario.setUsuario(usuarioBBDD.getUsuario());
		usuario.setPassword(usuarioBBDD.getPassword());
		return usuariosRepository.save(usuario);
	}

	@Override
	public Usuarios getUserByUsername(String username) {
		return usuariosRepository.findByUsername(username);
	}

}
