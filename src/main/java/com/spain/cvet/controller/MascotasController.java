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
import com.spain.cvet.dto.RecordatoriosDto;
import com.spain.cvet.model.Mascotas;
import com.spain.cvet.model.Recordatorios;
import com.spain.cvet.service.MascotasService;
import com.spain.cvet.service.RecordatoriosService;
import com.spain.cvet.utils.ConverterBeanToDto;

@RestController
@RequestMapping("/mascotas/")
public class MascotasController {
	
	@Autowired
	private MascotasService mascotasService;
	
	@Autowired
	private RecordatoriosService recordatoriosService;
	
	@GetMapping(path = "usuario/{username}")
	public ResponseEntity<List<MascotasDto>> getUserById(@PathVariable String username) throws Exception {
		List<MascotasDto> dtos = new ArrayList<>();
		List<Mascotas> mascotas = mascotasService.recuperarMascotasDeUsuario(username);
		for (Mascotas mascota : mascotas) {
			dtos.add(ConverterBeanToDto.convertMascotasToMascotasDto(mascota));
		}
		return new ResponseEntity<List<MascotasDto>>(dtos, HttpStatus.OK);
	}
	
	@GetMapping(path = "{mascotaId}")
	public ResponseEntity<MascotasDto> getInfoMascotaById(@PathVariable Integer mascotaId) throws Exception {
		MascotasDto dto = null;
		Mascotas mascota = mascotasService.recuperarInformacionDeMascota(mascotaId);
		List<Recordatorios> recordatorios = recordatoriosService.recuperarRecordatoriosByMascotaId(mascotaId);
		dto = ConverterBeanToDto.convertMascotasToMascotasDto(mascota);
		if(!recordatorios.isEmpty()){
			List<RecordatoriosDto> recordatoriosDto = new ArrayList<>(); 
			for (Recordatorios recordatorio : recordatorios) {
				recordatoriosDto.add(ConverterBeanToDto.convertRecordatoriosToRecordatoriosDto(recordatorio));
			}
			dto.setRecordatorios(recordatoriosDto);
		}
		return new ResponseEntity<MascotasDto>(dto, HttpStatus.OK);
	}

}
