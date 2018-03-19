package com.spain.cvet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spain.cvet.model.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
	
	@Query("SELECT c FROM Clientes c WHERE c.id= :id")
	public Clientes getById(@Param("id") Integer id);

}
