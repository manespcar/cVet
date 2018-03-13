package com.spain.cvet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spain.cvet.model.Mascotas;
import com.spain.cvet.repositories.MascotasRepository;
import com.spain.cvet.service.MascotasService;

@Service
public class MascotasServiceImpl implements MascotasService {
	
	@Autowired
	private MascotasRepository mascotasRepository;

	@Override
	public List<Mascotas> recuperarMascotasDeUsuario(Integer usuarioId) {
		return mascotasRepository.recuperarMascotasByUsuarioId(usuarioId);
	}

}
