package com.truper.catalogo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.configuration.JWUtil;
import com.truper.catalogo.tel.service.ProductoService;
import com.truper.saen.commons.dto.ListProductosDto;
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

	@GetMapping(value = "/recargaLista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> recargarLista(@RequestHeader("Authorization") String token){

		log.info("[GET /recargaLista] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta = productoService.recargarLista();
		log.info("[GET /recargaLista] | FIN");
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}
	
	@PostMapping(value = "/lista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getListaProductos(@RequestHeader("Authorization") String token,@RequestBody ListProductosDto lista ){
		log.info("[GET /lista] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta =productoService.listarProductos(lista);
		log.info("[GET /lista] | FIN");
		return new ResponseEntity<>(respuesta,respuesta.getEstado());
		
	}
}
