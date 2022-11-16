package com.truper.catalogo.tel.service;

import com.truper.catalogo.commons.Respuesta;

public interface ProveedorService {

	public Respuesta getProveedoresTel();
	
	public Respuesta getProveedoresTelImportacion();
	
	public Respuesta getProveedorById(String idProveedor);
	
	public Respuesta recargarLista();
	
}
