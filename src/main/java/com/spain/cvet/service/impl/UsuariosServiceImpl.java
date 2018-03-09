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
	public boolean checkLogin(String usuario, String password) {
		boolean exist = false;
		Usuarios usuarioBBDD = usuariosRepository.findByLogin(usuario, password);
		if(usuarioBBDD != null){
			exist = true;
		}
		return exist;
	}

}
