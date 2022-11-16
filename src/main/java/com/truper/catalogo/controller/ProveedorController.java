package com.truper.catalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.service.impl.ActualizarProveedor;
import com.truper.catalogo.tel.service.ProveedorService;
import com.truper.saen.commons.dto.ResponseVO;
import com.truper.saen.commons.enums.Mensajes;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/proveedor")
public class ProveedorController {
	
	@Autowired
	private ProveedorService proveedorService;
	
	@Autowired 
	private ActualizarProveedor provService;
	
	
	@GetMapping(value = "/tel", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getProveedoresTel(){
		Respuesta respuesta = proveedorService.getProveedoresTel();
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}
	
	@GetMapping(value = "/tel/{idProveedor}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getProveedorTelById(@PathVariable String idProveedor){
		Respuesta respuesta = proveedorService.getProveedorById(idProveedor);
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}
	
	@GetMapping(value = "/tel/importacion", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getProveedoresTelImportacion(){
		Respuesta respuesta = proveedorService.getProveedoresTel();
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}
	
	@GetMapping(value = "/actualiza", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseVO> getProveedoresByInicio(){
		provService.actualizarProveedores();
	
		Respuesta respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(),
				"Se inicia proceso de actualizacion de proveedores", "Status", "OK");
		respuesta.setEstado(HttpStatus.OK);
		
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}

}
