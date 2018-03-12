package com.spain.cvet.utils;

import com.spain.cvet.dto.UsuariosDto;
import com.spain.cvet.model.Usuarios;

public class ConverterBeanToDto {
	
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

}
