package com.truper.catalogo.saen.service;

import com.truper.catalogo.commons.Respuesta;

public interface PrioridadService {
	Respuesta getPrioridades();
	
	Respuesta getPrioridadByTipo(String tipo);
}
