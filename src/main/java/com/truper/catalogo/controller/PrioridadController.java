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
import com.truper.catalogo.saen.service.PrioridadService;
import com.truper.saen.commons.dto.ResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/prioridad")
@CrossOrigin(value = "*")
public class PrioridadController {
	
	@Autowired
	private PrioridadService prioridadService;
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getPrioridades(@RequestHeader("Authorization") String token){
		log.info("[GET /prioridades] | INICIO -  {} ",JWUtil.extractUsername(token.substring(7)));
		Respuesta resp =  prioridadService.getPrioridades();
		log.info("[GET /prioridades] | FIN");
		return new ResponseEntity<ResponseVO>(resp, resp.getEstado());
	}
	
	@GetMapping(value = "/getPrioridadesByTipo/{tipo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getPrioridadesByTipo(@RequestHeader("Authorization") String token,@PathVariable String tipo){
		log.info("[GET /getPrioridadesByTipo/{}] | INICIO -  {} ",tipo,JWUtil.extractUsername(token.substring(7)));
		Respuesta resp =  prioridadService.getPrioridadByTipo(tipo);
		log.info("[GET /getPrioridadesByTipo/] | FIN");
		return new ResponseEntity<ResponseVO>(resp, resp.getEstado());
	}
	

}
