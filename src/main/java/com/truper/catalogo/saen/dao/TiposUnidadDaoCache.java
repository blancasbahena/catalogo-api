package com.truper.catalogo.saen.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.truper.saen.commons.entities.catTipoDeUnidad;

@Service
public class TiposUnidadDaoCache {

	@Autowired
	private TiposUnidadDao tipoUnidadDao;
	
	@Cacheable(cacheNames = "listaTiposUnidad")
	public List<catTipoDeUnidad> findAllTiposUnidad(){
		
		return tipoUnidadDao.findByActivoIsTrue();
		
	}
	
}
