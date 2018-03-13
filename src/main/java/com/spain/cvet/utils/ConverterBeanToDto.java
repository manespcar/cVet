package com.spain.cvet.utils;

import java.text.SimpleDateFormat;

import com.spain.cvet.dto.MascotasDto;
import com.spain.cvet.dto.UsuariosDto;
import com.spain.cvet.model.Mascotas;
import com.spain.cvet.model.Usuarios;

public class ConverterBeanToDto {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public static UsuariosDto convertUsuariosToUsuariosDto(Usuarios bean){
		UsuariosDto dto = new UsuariosDto();
		dto.setId(bean.getId());
		dto.setNombreCompleto(bean.getNombreCompleto());
		dto.setDireccion(bean.getDireccion());
		dto.setTelefono(bean.getTelefono());
		dto.setEmail(bean.getEmail());
		dto.setUsuario(bean.getUsuario());
		return dto;
	}

	public static Usuarios convertUsuariosDtoToUsuarios(UsuariosDto dto) {
		Usuarios bean = new Usuarios();
		bean.setId(dto.getId());
		bean.setNombreCompleto(dto.getNombreCompleto());
		bean.setDireccion(dto.getDireccion());
		bean.setTelefono(dto.getTelefono());
		bean.setEmail(dto.getEmail());
		return bean;
	}

	public static MascotasDto convertMascotasToMascotasDto(Mascotas mascota) {
		MascotasDto dto = new MascotasDto();
		dto.setCapa(mascota.getCapa());
		dto.setChip(mascota.getChip());
		dto.setFechaNacimiento(sdf.format(mascota.getFechaNacimiento()));
		dto.setId(mascota.getId());
		dto.setNombre(mascota.getNombre());
		dto.setRaza(mascota.getRaza().getNombre());
		dto.setSexo(mascota.getSexo());
		return dto;
	}

}
