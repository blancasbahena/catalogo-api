package com.truper.catalogo.saen.service;

import com.truper.catalogo.commons.Respuesta;

public interface SucursalesService {

	public Respuesta getSucursales();
	
	public Respuesta getSucursalById(Integer idSucursal);
	
	public Respuesta recargarLista();
	
}
