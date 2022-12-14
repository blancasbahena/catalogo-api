package com.truper.catalogo.saen.service;

import com.truper.catalogo.commons.Respuesta;

public interface SucursalesService {

	public Respuesta getSucursales();
	
	public Respuesta getSucursalById(String idSucursal);
	
	public Respuesta recargarLista();
	
}
