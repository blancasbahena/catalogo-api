package com.truper.catalogo.tel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.truper.catalogo.tel.entities.ProductoTel;

public interface ProductoTelDao  extends JpaRepository<ProductoTel, String>{
	
	List<ProductoTel> findByRefaccionIsFalseAndObsoletoIsFalseOrProductoOEMIsTrue(); 

}
