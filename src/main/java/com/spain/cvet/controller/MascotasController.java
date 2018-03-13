package com.spain.cvet.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spain.cvet.dto.MascotasDto;
import com.spain.cvet.model.Mascotas;
import com.spain.cvet.service.MascotasService;
import com.spain.cvet.utils.ConverterBeanToDto;

@RestController
@RequestMapping("/mascotas/")
public class MascotasController {
	
	@Autowired
	private MascotasService mascotasService;
	
	@GetMapping(path = "usuario/{id}")
	public ResponseEntity<List<MascotasDto>> getUserById(@PathVariable Integer id) throws Exception {
		List<MascotasDto> dtos = new ArrayList<>();
		List<Mascotas> mascotas = mascotasService.recuperarMascotasDeUsuario(id);
		if(mascotas != null){
			for (Mascotas mascota : mascotas) {
				dtos.add(ConverterBeanToDto.convertMascotasToMascotasDto(mascota));
			}
			return new ResponseEntity<List<MascotasDto>>(dtos, HttpStatus.OK);
		}
		else
			return new ResponseEntity<List<MascotasDto>>(dtos, HttpStatus.NOT_FOUND);
	}

}
