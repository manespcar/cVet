package com.spain.cvet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spain.cvet.model.Vacunas;

@Repository
public interface VacunasRepository extends JpaRepository<Vacunas, Integer> {

}
