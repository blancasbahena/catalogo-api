package com.truper.catalogo.tel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.truper.catalogo.tel.entities.ProveedorTel;

public interface ProveedorTelDao extends JpaRepository<ProveedorTel, String>{

	List<ProveedorTel> findByBloqueadoIsFalseAndClaveProveedorStartsWith(String inicio);
	
	List<ProveedorTel> findByBloqueadoIsFalse();
	
}
