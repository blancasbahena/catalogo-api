package com.truper.catalogo.saen.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.truper.saen.commons.entities.CatCentro;

@Service
public class CentroDaoCache {

	@Autowired
	private CentroDao centroDao;
	
	@Cacheable(cacheNames = "catCentros")
	public List<CatCentro> findAllCentros(){
		
		return centroDao.findByActivoIsTrue();
		
	}
	
}
