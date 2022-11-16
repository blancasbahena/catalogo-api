package com.truper.catalogo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.commons.User;
import com.truper.catalogo.configuration.JWUtil;
import com.truper.catalogo.configuration.UserDetailsServices;
import com.truper.catalogo.enums.Mensajes;
import com.truper.saen.commons.dto.ResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/auth")
public class AuthController {
	
	@Autowired
	private UserDetailsServices userDetailsServices;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	

	@GetMapping(value =  "/status", produces = MediaType.APPLICATION_JSON_VALUE  )
	public ResponseEntity<ResponseVO> getStatusAPI(){
		log.info("[GET /status] | INICIO");
		Respuesta respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(),Mensajes.MSG_EXITO.getMensaje(),"resp","OK");
		respuesta.setEstado(HttpStatus.OK);
		log.info("[GET /status] | FIN");
		return new ResponseEntity<>(respuesta, respuesta.getEstado());
		
	}
	
	@PostMapping(value = "/authenticate",produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<ResponseVO> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {
		log.info("[POST /authenticate] | INICIO -  {}",authenticationRequest.getUsername());
		Respuesta respuesta;
		try {
			authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		} catch(Exception e) {
			log.error("Usuario o Contraseña no valida");
			respuesta = new Respuesta(Mensajes.TIPO_ERROR.getMensaje(), 
					Mensajes.MSG_TOKEN_ERROR.getMensaje(), "Error", e.getMessage());
			respuesta.setEstado(HttpStatus.BAD_REQUEST);
			return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
		}
		final UserDetails userDetails = userDetailsServices.loadUserByUsername(authenticationRequest.getUsername());
		final String token = JWUtil.generaToken(userDetails);
		log.info("Token generado");
		log.info("[POST /authenticate] | FIN -  {}",authenticationRequest.getUsername());
		respuesta =  new Respuesta(Mensajes.MSG_EXITO.getMensaje(), Mensajes.MSG_TOKEN_EXITO.getMensaje(), "token", token);
		respuesta.setEstado(HttpStatus.OK);
		return new ResponseEntity<ResponseVO>(respuesta, respuesta.getEstado());
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
}
