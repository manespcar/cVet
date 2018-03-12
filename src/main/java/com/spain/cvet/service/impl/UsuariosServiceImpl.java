package com.spain.cvet.service.impl;

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
	public Usuarios checkLogin(String usuario, String password) {
		Usuarios usuarioBBDD = usuariosRepository.findByLogin(usuario, password);
		usuarioBBDD.setPassword(null);
		return usuarioBBDD;
	}

	@Override
	public Usuarios getUserById(Integer id) {
		return usuariosRepository.getOne(id);
	}

}
