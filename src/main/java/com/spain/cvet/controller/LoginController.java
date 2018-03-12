package com.spain.cvet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spain.cvet.dto.UsuariosDto;
import com.spain.cvet.model.Usuarios;
import com.spain.cvet.service.UsuariosService;
import com.spain.cvet.utils.ConverterBeanToDto;

@RestController
@RequestMapping("/login/")
public class LoginController {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@PostMapping(value = "check")
	public ResponseEntity<UsuariosDto> login(@RequestBody Usuarios user) throws Exception {
		UsuariosDto dto = null;
		Usuarios usuario = usuariosService.checkLogin(user.getUsuario(), user.getPassword());
		if(usuario != null){
			dto = ConverterBeanToDto.convertUsuariosToUsuariosDto(usuario);
			return new ResponseEntity<UsuariosDto>(dto, HttpStatus.OK);
		}
		else
			return new ResponseEntity<UsuariosDto>(dto, HttpStatus.NOT_FOUND);
	}

}
