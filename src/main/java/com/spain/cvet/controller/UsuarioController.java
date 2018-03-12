package com.spain.cvet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spain.cvet.dto.UsuariosDto;
import com.spain.cvet.model.Usuarios;
import com.spain.cvet.service.UsuariosService;
import com.spain.cvet.utils.ConverterBeanToDto;

@RestController
@RequestMapping("/usuario/")
public class UsuarioController {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@GetMapping(path = "{id}")
	public ResponseEntity<UsuariosDto> getUserById(@PathVariable Integer id) throws Exception {
		UsuariosDto dto = null;
		Usuarios usuario = usuariosService.getUserById(id);
		if(usuario != null){
			dto = ConverterBeanToDto.convertUsuariosToUsuariosDto(usuario);
			return new ResponseEntity<UsuariosDto>(dto, HttpStatus.OK);
		}
		else
			return new ResponseEntity<UsuariosDto>(dto, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping(value = "save")
	public ResponseEntity<UsuariosDto> saveUser(@RequestBody UsuariosDto dto) throws Exception {
		Usuarios usuario = usuariosService.saveUser(ConverterBeanToDto.convertUsuariosDtoToUsuarios(dto));
		if(usuario != null){
			dto = ConverterBeanToDto.convertUsuariosToUsuariosDto(usuario);
			return new ResponseEntity<UsuariosDto>(dto, HttpStatus.OK);
		}
		else
			return new ResponseEntity<UsuariosDto>(dto, HttpStatus.NOT_FOUND);
	}

}
