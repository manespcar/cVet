package com.spain.cvet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spain.cvet.model.Recordatorios;
import com.spain.cvet.repositories.RecordatoriosRepository;
import com.spain.cvet.service.RecordatoriosService;

@Service
public class RecordatoriosServiceImpl implements RecordatoriosService {
	
	@Autowired
	private RecordatoriosRepository recordatoriosRepository;

	@Override
	public List<Recordatorios> recuperarRecordatoriosByMascotaId(Integer mascotaId) {
		return recordatoriosRepository.recuperarRecordatoriosByMascotaId(mascotaId);
	}
	
	
}
