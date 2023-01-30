package com.truper.catalogo.tel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.truper.catalogo.tel.entities.PlaneadorTel;
import com.truper.catalogo.tel.entities.ProveedorTel;
import com.truper.catalogo.tel.entities.UsuariosTel;

@Service
public class PlaneadorTelDaoCache {

	@Autowired
	private PlaneadorTelDao planeadorTelDao;
	
	@Autowired
	private CacheManager cacheManager;
	
	@Cacheable(cacheNames = "listaPlaneadoresImportacion")
	public List<PlaneadorTel> findPlaneador(){
		return planeadorTelDao.findAll();
	}
	
	@Cacheable(cacheNames = "listaPlaneadoresImportacion", key = "#idPlanner")
	public PlaneadorTel findPlaneadorById(String idPlanner){
		return planeadorTelDao.findByCodigoPlaneador(idPlanner);
	}
	
	public void recargarLista() {
		cacheManager.getCache("listaProveedoresImportacion").clear();
		this.findPlaneador();
	}
}
