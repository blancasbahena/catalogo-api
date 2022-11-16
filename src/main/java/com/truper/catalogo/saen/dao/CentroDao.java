package com.truper.catalogo.saen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truper.saen.commons.entities.CatCentro;

public interface CentroDao extends JpaRepository<CatCentro, String>{

	 List<CatCentro> findByActivoIsTrue();
	
}
