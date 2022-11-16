package com.truper.catalogo.tel.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.truper.catalogo.tel.entities.ProductoTel;

@Service
public class ProductoTelDaoCache {

	@Autowired
	private ProductoTelDao productoDao;
	
	@Cacheable(cacheNames = "listaProductos")
	public List<ProductoTel> findAllProductos(){
		return productoDao.findByRefaccionIsFalseAndObsoletoIsFalseOrProductoOEMIsTrue();
	}
	
	@Cacheable(cacheNames = "listaProductos", key = "#id")
	public ProductoTel findProductoById(String id){
		return productoDao.findById(id).orElse(null);
	}
	
	
}
