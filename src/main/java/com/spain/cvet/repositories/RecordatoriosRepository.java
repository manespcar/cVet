package com.spain.cvet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spain.cvet.model.Recordatorios;

@Repository
public interface RecordatoriosRepository extends JpaRepository<Recordatorios, Integer> {
	
	@Query("SELECT r FROM Recordatorios r WHERE r.mascotas.id = :mascotaId")
	public List<Recordatorios> recuperarRecordatoriosByMascotaId(@Param("mascotaId") Integer mascotaId);

}
