package com.truper.catalogo.saen.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.truper.saen.commons.entities.Sucursal;

@Service
public class SucursalDaoCache {

	@Autowired 
	private SucursalDao sucursalDao;
	
	@Autowired
	private CacheManager cacheManager;
	
	@Cacheable(cacheNames = "catSucursales")
	public List<Sucursal> findAllSucursales(){
		return sucursalDao.findByActivoIsTrue();
	}
	
	@Cacheable(cacheNames = "catSucursales", key = "#idSucursal")
	public Sucursal findSucursalById(Integer idSucursal){
		return sucursalDao.findById(idSucursal).orElse(null);
	}
	
	public void recargarLista() {
		cacheManager.getCache("catSucursales").clear();
		this.findAllSucursales();
		
	}
	
}
