package com.truper.catalogo.saen.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truper.saen.commons.entities.Sucursal;

public interface SucursalDao extends JpaRepository<Sucursal,Integer> {
	
	List<Sucursal> findByActivoIsTrue();

}
