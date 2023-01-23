package com.truper.catalogo.tel.service;

import com.truper.catalogo.commons.Respuesta;
import com.truper.saen.commons.dto.ListProductosDto;

public interface ProductoService {

	Respuesta getAllProductos();
	
	Respuesta getProductoById(String idProducto);
	
	Respuesta recargarLista();
	
	Respuesta listarProductos(ListProductosDto productos);
}
