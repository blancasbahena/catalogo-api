package com.truper.catalogo.tel.service;

import java.util.List;

import com.truper.catalogo.commons.Respuesta;

public interface PlaneadorService {

	public Respuesta getPlaneadoresTel();
	
	public Respuesta recargarLista();

	Respuesta getPlaneadoresbyList(List<String> planners);
	
}
