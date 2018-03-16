package com.spain.cvet.service;

import com.spain.cvet.model.Usuarios;

public interface UsuariosService {

	public Usuarios getUserById(Integer id);

	public Usuarios saveUser(Usuarios usuario);
	
	public Usuarios getUserByUsername(String username);
}
