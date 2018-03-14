package com.spain.cvet.utils;

import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

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
		dto.setImagen(bean.getImagen());
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
		dto.setCapa(mascota.getCapa().toUpperCase());
		dto.setChip(StringUtils.isEmpty(mascota.getChip()) ? "-" : mascota.getChip());
		dto.setFechaNacimiento(sdf.format(mascota.getFechaNacimiento()));
		dto.setId(mascota.getId());
		dto.setNombre(mascota.getNombre().toUpperCase());
		dto.setRaza(mascota.getRaza().getNombre().toUpperCase());
		dto.setSexo(mascota.getSexo().toUpperCase());
		dto.setEspecie(mascota.getEspecie().getNombre());
		if(mascota.getEspecie().getId() == 1){ //perro
			dto.setImagen("assets/imgs/dog.png");
		} else if (mascota.getEspecie().getId() == 2){ //gato
			dto.setImagen("assets/imgs/cat.png");
		}
		return dto;
	}

}
