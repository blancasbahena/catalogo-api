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
import com.truper.catalogo.saen.service.CentroService;
import com.truper.saen.commons.dto.ResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/centros")
@CrossOrigin(value = "*")
public class CentrosController {

	@Autowired
	private CentroService centroService;
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getTiposDeUnidad(@RequestHeader("Authorization") String token){
		log.info("[GET /centros] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta resp =  centroService.getCentros();
		log.info("[GET /centros] | FIN");
		return new ResponseEntity<ResponseVO>(resp, resp.getEstado());
	}
	
	@GetMapping(value = "/{idCentro}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getTiposDeUnidadById(@RequestHeader("Authorization") String token,@PathVariable String idCentro){
		log.info("[GET /centros/{}] | INICIO -  {} ",idCentro,JWUtil.extractUsername(token.substring(7)));
		Respuesta resp =  centroService.getCentros();
		log.info("[GET /centros] | FIN");
		return new ResponseEntity<ResponseVO>(resp, resp.getEstado());
	}
	
	@GetMapping(value = "/recargaLista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> recargarLista(@RequestHeader("Authorization") String token){
		log.info("[GET /recargaLista] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta resp =  centroService.getCentros();
		log.info("[GET /recargaLista] | FIN");
		return new ResponseEntity<ResponseVO>(resp, resp.getEstado());
	}
	
	
}
