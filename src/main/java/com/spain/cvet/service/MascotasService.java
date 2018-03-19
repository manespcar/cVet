package com.spain.cvet.service;

import java.util.List;

import com.spain.cvet.model.Mascotas;

public interface MascotasService {
	
	public List<Mascotas> recuperarMascotasDeUsuario(String username);

	public Mascotas recuperarInformacionDeMascota(Integer mascotaId);

}
