package com.spain.cvet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spain.cvet.model.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
	
	@Query("SELECT u FROM Usuarios u WHERE u.usuario = :usuario AND u.password = :password")
	public Usuarios findByLogin(@Param("usuario") String usuario, @Param("password") String password);

}
