package com.spain.cvet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spain.cvet.model.Usuarios;
import com.spain.cvet.service.UsuariosService;

@RestController
@RequestMapping("/usuario/")
public class UsuarioController {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@GetMapping(path = "{id}")
	public ResponseEntity<Usuarios> getUserById(@PathVariable Integer id) throws Exception {
		Usuarios usuario = usuariosService.getUserById(id);
		if(usuario != null)
			return new ResponseEntity<Usuarios>(usuario, HttpStatus.OK);
		else
			return new ResponseEntity<Usuarios>(usuario, HttpStatus.NOT_FOUND);
	}

}
