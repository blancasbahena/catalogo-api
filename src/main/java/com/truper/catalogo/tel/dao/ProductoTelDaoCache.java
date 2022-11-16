package com.truper.catalogo.tel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.truper.catalogo.tel.entities.ProductoTel;

@Service
public class ProductoTelDaoCache {

	@Autowired
	private ProductoTelDao productoDao;
	
	@Autowired
	private CacheManager cacheManager;
	
	@Cacheable(cacheNames = "listaProductos")
	public List<ProductoTel> findAllProductos(){
		return productoDao.findByRefaccionIsFalseAndObsoletoIsFalseOrProductoOEMIsTrue();
	}
	
	@Cacheable(cacheNames = "listaProductos", key = "#id")
	public ProductoTel findProductoById(String id){
		return productoDao.findById(id).orElse(null);
	}
	
	public void recargarLista() {
		cacheManager.getCache("listaProductos").clear();
		this.findAllProductos();
	}
}
