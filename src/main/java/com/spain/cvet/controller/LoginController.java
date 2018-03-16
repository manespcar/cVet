package com.spain.cvet.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
//	@Autowired
//	private UsuariosService usuariosService;
//	
//	@PostMapping(value = "/login")
//	public ResponseEntity<UsuariosDto> login(@RequestBody Usuarios user) throws Exception {
//		UsuariosDto dto = null;
//		Usuarios usuario = usuariosService.checkLogin(user.getUsuario(), user.getPassword());
//		if(usuario != null){
//			dto = ConverterBeanToDto.convertUsuariosToUsuariosDto(usuario);
//			return new ResponseEntity<UsuariosDto>(dto, HttpStatus.OK);
//		}
//		else
//			return new ResponseEntity<UsuariosDto>(dto, HttpStatus.NOT_FOUND);
//	}

}
