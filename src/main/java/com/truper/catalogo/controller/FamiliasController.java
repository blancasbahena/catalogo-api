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
import com.truper.catalogo.tel.service.FamiliasService;
import com.truper.catalogo.tel.service.PlaneadorService;
import com.truper.saen.commons.dto.ResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/familias")
public class FamiliasController {
	
	@Autowired
	private FamiliasService familiasService;	
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getPlaneadores(@RequestHeader("Authorization") String token){
		log.info("[GET /familias] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta = familiasService.getFamilias();
		log.info("[GET /proveedor/tel] | FIN");
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}
	
	@GetMapping(value = "/{idFamilia}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getPlaneadoresbyList(@RequestHeader("Authorization") String token, @PathVariable String idFamilia){
		log.info("[GET /familias/{}] | INICIO -  {} ",idFamilia,JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta = familiasService.getFamilia(idFamilia);
		log.info("[GET /proveedor/tel] | FIN");
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}
	
	@GetMapping(value = "/recargaLista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getProveedoresByInicio(@RequestHeader("Authorization") String token){
		log.info("[GET /familias/recargaLista] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta = familiasService.recargarLista();
		log.info("[GET /familias/recargaLista] | FIN");
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}

}
