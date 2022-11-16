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
import com.truper.catalogo.tel.service.ProveedorService;
import com.truper.saen.commons.dto.ResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/proveedor")
public class ProveedorController {
	
	@Autowired
	private ProveedorService proveedorService;	
	
	@GetMapping(value = "/tel", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getProveedoresTel(@RequestHeader("Authorization") String token){
		log.info("[GET /proveedor/tel] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta = proveedorService.getProveedoresTel();
		log.info("[GET /proveedor/tel] | FIN");
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}
	
	@GetMapping(value = "/tel/{idProveedor}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getProveedorTelById(@RequestHeader("Authorization") String token,@PathVariable String idProveedor){
		log.info("[GET /proveedor/tel/{}] | INICIO -  {} ",idProveedor,JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta = proveedorService.getProveedorById(idProveedor);
		log.info("[GET /proveedor/tel/{}] | FIN",idProveedor);
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}
	
	@GetMapping(value = "/tel/importacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getProveedoresTelImportacion(@RequestHeader("Authorization") String token){
		log.info("[GET /proveedor/importacion] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta = proveedorService.getProveedoresTel();
		log.info("[GET /proveedor/importacion] | FIN");
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}
	
	@GetMapping(value = "/recargaLista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getProveedoresByInicio(@RequestHeader("Authorization") String token){
		log.info("[GET /recargaLista] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta = proveedorService.recargarLista();
		log.info("[GET /recargaLista] | FIN");
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}

}
