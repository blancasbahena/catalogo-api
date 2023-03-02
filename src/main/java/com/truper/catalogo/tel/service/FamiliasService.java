package com.truper.catalogo.tel.service;

import com.truper.catalogo.commons.Respuesta;

public interface FamiliasService {

	public Respuesta getFamilias();
	
	public Respuesta recargarLista();

	Respuesta getFamilia(String idFamilia);
	
}
