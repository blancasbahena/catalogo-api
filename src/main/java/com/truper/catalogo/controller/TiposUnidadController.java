package com.truper.catalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.saen.service.TiposUnidadService;
import com.truper.saen.commons.dto.ResponseVO;

@RestController
@RequestMapping(value = "/TiposUnidad")
@CrossOrigin(value = "*")
public class TiposUnidadController {
	
	@Autowired
	private TiposUnidadService tUnidadService;
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getTiposDeUnidad(){
		
		Respuesta resp =  tUnidadService.getTiposDeUnidad();
		
		return new ResponseEntity<ResponseVO>(resp, resp.getEstado());
	}
	
}
