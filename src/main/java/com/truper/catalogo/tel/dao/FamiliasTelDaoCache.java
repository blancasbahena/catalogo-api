package com.truper.catalogo.tel.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.truper.catalogo.tel.entities.Familias;
import com.truper.catalogo.tel.entities.PlaneadorTel;
import com.truper.catalogo.tel.entities.ProveedorTel;
import com.truper.catalogo.tel.entities.UsuariosTel;

@Service
public class FamiliasTelDaoCache {

	@Autowired
	private FamiliasTelDao familiasTelDao;
	
	@Autowired
	private CacheManager cacheManager;
	
	@Cacheable(cacheNames = "listaFamilias")
	public List<Familias> findFamilias(){
		return familiasTelDao.findAll();
	}
	
	@Cacheable(cacheNames = "listaFamilias", key = "#codigo")
	public Familias findFamiliaByID(String codigo){
		Optional<Familias> opt=familiasTelDao.findById(codigo);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}
	
	public void recargarLista() {
		cacheManager.getCache("listaFamilias").clear();
		this.findFamilias();
	}
}
