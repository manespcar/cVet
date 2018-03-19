package com.spain.cvet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spain.cvet.model.Mascotas;
import com.spain.cvet.model.Usuarios;
import com.spain.cvet.repositories.MascotasRepository;
import com.spain.cvet.service.MascotasService;
import com.spain.cvet.service.UsuariosService;

@Service
public class MascotasServiceImpl implements MascotasService {
	
	@Autowired
	private MascotasRepository mascotasRepository;
	
	@Autowired
	private UsuariosService usuariosService;
	
	@Override
	public List<Mascotas> recuperarMascotasDeUsuario(String username) {
		Usuarios usuario = usuariosService.getUserByUsername(username);
		return mascotasRepository.recuperarMascotasByUsuarioId(usuario.getClienteId());
	}

	@Override
	public Mascotas recuperarInformacionDeMascota(Integer mascotaId) {
		return mascotasRepository.getOne(mascotaId);
	}

}
