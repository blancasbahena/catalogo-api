package com.truper.catalogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.configuration.JWUtil;
import com.truper.catalogo.tel.service.PlaneadorService;
import com.truper.catalogo.tel.service.ProveedorService;
import com.truper.saen.commons.dto.ResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/planeador")
public class PlaneadorController {
	
	@Autowired
	private PlaneadorService planeadorService;	
	
	@GetMapping(value = "/planner", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getPlaneadores(@RequestHeader("Authorization") String token){
		log.info("[GET /proveedor/tel] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta = planeadorService.getPlaneadoresTel();
		log.info("[GET /proveedor/tel] | FIN");
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}
	
	@GetMapping(value = "/plannersbyList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getPlaneadoresbyList(@RequestHeader("Authorization") String token, @RequestBody List<String> planners){
		log.info("[GET /proveedor/tel] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta = planeadorService.getPlaneadoresbyList(planners);
		log.info("[GET /proveedor/tel] | FIN");
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}
	
	@GetMapping(value = "/recargaLista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getProveedoresByInicio(@RequestHeader("Authorization") String token){
		log.info("[GET /recargaLista] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta = planeadorService.recargarLista();
		log.info("[GET /recargaLista] | FIN");
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}

}
