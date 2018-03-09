package com.spain.cvet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spain.cvet.model.Usuarios;
import com.spain.cvet.service.UsuariosService;

@RestController
@RequestMapping("/login/")
public class LoginController {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@PostMapping(value = "check")
	public ResponseEntity<Usuarios> login(@RequestBody Usuarios user) throws Exception {
		boolean check = usuariosService.checkLogin(user.getUsuario(), user.getPassword());
		if(check)
			return new ResponseEntity<Usuarios>(HttpStatus.OK);
		else
			return new ResponseEntity<Usuarios>(HttpStatus.NOT_FOUND);
	}

}
