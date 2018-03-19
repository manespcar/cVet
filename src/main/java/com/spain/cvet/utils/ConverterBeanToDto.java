package com.spain.cvet.utils;

import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;

import com.spain.cvet.dto.MascotasDto;
import com.spain.cvet.dto.RecordatoriosDto;
import com.spain.cvet.dto.UsuariosDto;
import com.spain.cvet.model.Clientes;
import com.spain.cvet.model.Mascotas;
import com.spain.cvet.model.Recordatorios;
import com.spain.cvet.model.Usuarios;

public class ConverterBeanToDto {
	
	private static final String GUION = "-";
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
	public static UsuariosDto convertUsuariosToUsuariosDto(Usuarios bean){
		UsuariosDto dto = new UsuariosDto();
		dto.setNombreCompleto(bean.getCliente().getNombreCompleto());
		dto.setDireccion(bean.getCliente().getDireccion());
		dto.setTelefono(bean.getCliente().getTelefono());
		dto.setEmail(bean.getCliente().getEmail());
		dto.setUsername(bean.getUsuario());
		dto.setImagen(bean.getImagen());
		return dto;
	}

	public static Usuarios convertUsuariosDtoToUsuarios(UsuariosDto dto) {
		Usuarios bean = new Usuarios();
		Clientes cliente = new Clientes();
		cliente.setNombreCompleto(dto.getNombreCompleto());
		cliente.setDireccion(dto.getDireccion());
		cliente.setTelefono(dto.getTelefono());
		cliente.setEmail(dto.getEmail());
		bean.setUsuario(dto.getUsername());
		bean.setCliente(cliente);
		bean.setImagen(dto.getImagen());
		return bean;
	}

	public static MascotasDto convertMascotasToMascotasDto(Mascotas mascota) {
		MascotasDto dto = new MascotasDto();
		dto.setCapa(mascota.getCapa().toUpperCase());
		dto.setChip(StringUtils.isEmpty(mascota.getChip()) ? GUION : mascota.getChip());
		dto.setFechaNacimiento(mascota.getFechaNacimiento() != null ? sdf.format(mascota.getFechaNacimiento()) : GUION);
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

	public static RecordatoriosDto convertRecordatoriosToRecordatoriosDto(Recordatorios recordatorio) {
		RecordatoriosDto dto = new RecordatoriosDto();
		dto.setVacuna(recordatorio.getVacunas().getNombre());
		dto.setFechaVacunacion(recordatorio.getFechaVacunacion() != null ? sdf.format(recordatorio.getFechaVacunacion()) : GUION);
		dto.setFechaProxVacunacion(recordatorio.getFechaProxVacunacion() != null ? sdf.format(recordatorio.getFechaProxVacunacion()) : GUION);
		return dto;
	}

}
