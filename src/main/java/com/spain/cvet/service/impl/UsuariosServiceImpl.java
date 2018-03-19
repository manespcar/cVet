package com.spain.cvet.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spain.cvet.model.Usuarios;
import com.spain.cvet.repositories.UsuariosRepository;
import com.spain.cvet.service.ClientesService;
import com.spain.cvet.service.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService {
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Autowired
	private ClientesService clientesService;

	@Override
	public Usuarios saveUser(Usuarios usuario) {
		Usuarios usuarioBBDD = usuariosRepository.getOne(usuario.getUsuario());
		
		usuario.getCliente().setId(usuarioBBDD.getClienteId());
		clientesService.saveCliente(usuario.getCliente());
		
		usuarioBBDD.setFechaCambio(new Date());
		usuarioBBDD.setImagen(usuario.getImagen());
		usuariosRepository.save(usuarioBBDD);
		return usuario;
	}

	@Override
	public Usuarios getUserAndClienteByUsername(String username) {
		Usuarios usuario = usuariosRepository.findByUsername(username);
		usuario.setCliente(clientesService.getClienteById(usuario.getClienteId()));
		return usuario;
	}
	
	@Override
	public Usuarios getUserByUsername(String username) {
		Usuarios usuario = usuariosRepository.findByUsername(username);
		return usuario;
	}

}
