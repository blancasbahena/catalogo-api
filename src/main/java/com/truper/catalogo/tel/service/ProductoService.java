package com.truper.catalogo.tel.service;

import com.truper.catalogo.commons.Respuesta;

public interface ProductoService {

	Respuesta getAllProductos();
	
	Respuesta getProductoById(String idProducto);
	
	Respuesta recargarLista();
	
}
