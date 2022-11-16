package com.truper.catalogo.commons;


import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.truper.saen.commons.dto.ResponseVO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Respuesta extends ResponseVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    @JsonIgnore
    private HttpStatus estado;

	public Respuesta(String tipo, String msg, String nombreObjeto, Object data) {
		super(tipo, msg, nombreObjeto, data);
	}
    
}
