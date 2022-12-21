package com.truper.catalogo.saen.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.truper.saen.commons.entities.CatCentro;
import com.truper.saen.commons.entities.CatPrioridades;

@Service
public class PrioridadDaoCache {
	
	@Autowired
	private CatPrioridadDao prioridadDao;
	
	@Autowired
	private CacheManager cacheManager;
	
	@Cacheable(cacheNames = "catPrioridades")
	public List<CatPrioridades> findAllPrioridades(){
		
		return prioridadDao.findAll();
		
	}
	
	@Cacheable(cacheNames = "catPrioridades", key = "#tipo")
	public List<CatPrioridades> findByTipo(String tipo){
		
		return prioridadDao.findByTipo(tipo);
		
	}
	
	public void recargarLista() {
		cacheManager.getCache("catPrioridades").clear();
		this.findAllPrioridades();
		
	}
	
	

}
