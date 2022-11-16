package com.truper.catalogo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.truper.catalogo.saen.dao.CentroDaoCache;
import com.truper.catalogo.saen.dao.TiposUnidadDaoCache;
import com.truper.catalogo.tel.dao.ProductoTelDaoCache;
import com.truper.catalogo.tel.dao.ProveedorTelDaoCache;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ActualizaListas {

	@Autowired
	private CacheManager cacheManager;
	
	@Autowired
	private CentroDaoCache centroDao;
	
	@Autowired
	private TiposUnidadDaoCache tiposUnidadDao; 
	
	@Autowired
	private ProveedorTelDaoCache proveedorDao; 
	
	@Autowired
	private ProductoTelDaoCache productoDao;
	
	
	@Scheduled(cron = "${api.crones.listaCentros}")
	public void actualizaProductos() {
		log.info("[INICIO] Actualizando listas...");
		cacheManager.getCache("catCentros").clear();
		centroDao.findAllCentros();
		
		cacheManager.getCache("listaTiposUnidad").clear();
		tiposUnidadDao.findAllTiposUnidad();
		
		cacheManager.getCache("listaProveedores").clear();
		proveedorDao.findAllProveedores();
		
		cacheManager.getCache("listaProductos").clear();
		productoDao.findAllProductos();
		
		log.info("[FIN] Listas actualizadas ");
	}
	
	
}
