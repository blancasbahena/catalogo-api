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
import com.truper.catalogo.saen.service.TiposUnidadService;
import com.truper.saen.commons.dto.ResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/TiposUnidad")
@CrossOrigin(value = "*")
public class TiposUnidadController {
	
	@Autowired
	private TiposUnidadService tUnidadService;
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getTiposDeUnidad(@RequestHeader("Authorization") String token){
		log.info("[GET /TiposUnidad] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta resp =  tUnidadService.getTiposDeUnidad();
		log.info("[GET /TiposUnidad] | FIN");
		return new ResponseEntity<ResponseVO>(resp, resp.getEstado());
	}
	
	@GetMapping(value = "/{idTipoUnidad}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getTipoDeUnidadById(@RequestHeader("Authorization") String token,@PathVariable Integer idTipoUnidad){
		log.info("[GET /TiposUnidad/{}] | INICIO -  {} ",idTipoUnidad,JWUtil.extractUsername(token.substring(7)));
		Respuesta resp =  tUnidadService.getTipoUnidadById(idTipoUnidad);
		log.info("[GET /TiposUnidad/{}] | FIN",idTipoUnidad);
		return new ResponseEntity<ResponseVO>(resp, resp.getEstado());
	}
	
	@GetMapping(value = "/recargaLista", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> recargarLista(@RequestHeader("Authorization") String token){
		log.info("[GET /recargaLista] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta respuesta = tUnidadService.recargarLista();
		log.info("[GET /recargaLista] | FIN");
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}
}
