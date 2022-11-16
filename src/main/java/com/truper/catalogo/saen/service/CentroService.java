package com.truper.catalogo.saen.service;

import com.truper.catalogo.commons.Respuesta;

public interface CentroService {

	public Respuesta getCentros();
	
	public Respuesta getCentroById(String idCentro);
	
	public Respuesta recargarLista();
	
}
