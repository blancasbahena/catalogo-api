package com.truper.catalogo.saen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truper.saen.commons.entities.CatTipoDeUnidad;

public interface TiposUnidadDao extends JpaRepository<CatTipoDeUnidad, Integer>{

	List<CatTipoDeUnidad> findByActivoIsTrue();
	
}
