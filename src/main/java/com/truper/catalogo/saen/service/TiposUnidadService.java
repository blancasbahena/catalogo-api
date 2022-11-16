package com.truper.catalogo.saen.service;

import com.truper.catalogo.commons.Respuesta;

public interface TiposUnidadService {

	Respuesta getTiposDeUnidad();
	
	Respuesta getTipoUnidadById(Integer idTipoUnidad);
	
	Respuesta recargarLista();
	
}
