package com.spain.cvet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spain.cvet.model.Mascotas;

@Repository
public interface MascotasRepository extends JpaRepository<Mascotas, Integer> {
	
	@Query("SELECT m FROM Mascotas m WHERE m.clienteId = :usuarioId")
	public List<Mascotas> recuperarMascotasByUsuarioId(@Param("usuarioId") Integer usuarioId);

}
