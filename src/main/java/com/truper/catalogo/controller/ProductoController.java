package com.truper.catalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.configuration.JWUtil;
import com.truper.catalogo.tel.service.ProductoService;

import com.truper.saen.commons.dto.ResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getProductos(@RequestHeader("Authorization") String token ){
		log.info("[GET /productos] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta = productoService.getAllProductos();
		log.info("[GET /productos] | FIN");
		return new ResponseEntity<>(respuesta,respuesta.getEstado());
		
	}
	
	@GetMapping(value = "/{idProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getProductoById(@RequestHeader("Authorization") String token,@PathVariable String idProducto ){
		log.info("[GET /productos/{}] | INICIO -  {} ",idProducto,JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta = productoService.getProductoById(idProducto);
		log.info("[GET /productos/{}] | FIN",idProducto);
		return new ResponseEntity<>(respuesta,respuesta.getEstado());
		
	}

}
