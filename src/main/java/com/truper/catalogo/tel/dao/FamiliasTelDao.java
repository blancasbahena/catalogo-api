package com.truper.catalogo.tel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.truper.catalogo.tel.entities.Familias;


public interface FamiliasTelDao extends JpaRepository<Familias, String>{
	
}
