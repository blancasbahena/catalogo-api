package com.truper.catalogo.saen.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.truper.saen.commons.entities.CatTipoDeUnidad;

@Service
public class TiposUnidadDaoCache {

	@Autowired
	private TiposUnidadDao tipoUnidadDao;
	
	@Autowired
	private CacheManager cacheManager;
	
	@Cacheable(cacheNames = "listaTiposUnidad")
	public List<CatTipoDeUnidad> findAllTiposUnidad(){
		return tipoUnidadDao.findByActivoIsTrue();
	}
	
	@Cacheable(cacheNames = "listaTiposUnidad", key = "#idTipoUnidad")
	public CatTipoDeUnidad findTipoUnidadById(Integer idTipoUnidad){
		return tipoUnidadDao.findById(idTipoUnidad).orElse(null);
	}
	
	public void recargarLista() {
		cacheManager.getCache("listaTiposUnidad").clear();
		this.findAllTiposUnidad();
	}
	
}
