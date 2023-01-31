package com.truper.catalogo.tel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.truper.catalogo.tel.entities.PlaneadorTel;
import com.truper.catalogo.tel.entities.ProveedorTel;

public interface PlaneadorTelDao extends JpaRepository<PlaneadorTel, String>{
	
	PlaneadorTel findByCodigoPlaneador(String planner);
}
