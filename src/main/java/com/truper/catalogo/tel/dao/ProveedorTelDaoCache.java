package com.truper.catalogo.tel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.truper.catalogo.tel.entities.ProveedorTel;

@Service
public class ProveedorTelDaoCache {

	@Autowired
	private ProveedorTelDao proveedorDao;
	
	@Autowired
	private CacheManager cacheManager;
	
	@Value("${api.datasource.tel.prefijo}")
	private String prefijoProvImportacion;
	
	@Cacheable(cacheNames = "listaProveedoresImportacion")
	public List<ProveedorTel> findProveedoresImportacion(){
		return proveedorDao.findByBloqueadoIsFalseAndClaveProveedorStartsWith(prefijoProvImportacion);
	}
	
	@Cacheable(cacheNames = "listaProveedores")
	public List<ProveedorTel> findAllProveedores(){
		return proveedorDao.findAll();
	}
	
	@Cacheable(cacheNames = "listaProveedores", key = "#idProveedor")
	public ProveedorTel findProveedorById(String idProveedor){
		return proveedorDao.findById(idProveedor).orElse(null);
	}
	
	public void recargarLista() {
		cacheManager.getCache("listaProveedores").clear();
		cacheManager.getCache("listaProveedoresImportacion").clear();
		this.findAllProveedores();
		this.findProveedoresImportacion();
	}
}
