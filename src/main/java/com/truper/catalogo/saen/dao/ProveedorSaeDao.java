package com.truper.catalogo.saen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truper.saen.commons.entities.Proveedor;


public interface ProveedorSaeDao extends JpaRepository<Proveedor, String>{

	List<Proveedor> findByBloqueadoIsFalse();
	
}
