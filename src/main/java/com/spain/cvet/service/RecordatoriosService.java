package com.spain.cvet.service;

import java.util.List;

import com.spain.cvet.model.Recordatorios;

public interface RecordatoriosService {
	
	public List<Recordatorios> recuperarRecordatoriosByMascotaId(Integer mascotaId);

}
