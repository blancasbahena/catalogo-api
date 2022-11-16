package com.truper.catalogo.saen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truper.saen.commons.entities.catTipoDeUnidad;

public interface TiposUnidadDao extends JpaRepository<catTipoDeUnidad, Integer>{

	List<catTipoDeUnidad> findByActivoIsTrue();
	
}
