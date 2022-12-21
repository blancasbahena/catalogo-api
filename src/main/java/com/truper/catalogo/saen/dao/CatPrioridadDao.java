package com.truper.catalogo.saen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truper.saen.commons.entities.CatPrioridades;

public interface CatPrioridadDao  extends JpaRepository<CatPrioridades, Integer> {
	
	
	List<CatPrioridades> findByTipo(String tipo);
}
