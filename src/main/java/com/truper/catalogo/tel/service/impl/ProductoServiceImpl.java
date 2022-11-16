package com.truper.catalogo.tel.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.tel.dao.ProductoTelDaoCache;
import com.truper.catalogo.tel.entities.ProductoTel;
import com.truper.catalogo.tel.service.ProductoService;
import com.truper.saen.commons.enums.Mensajes;
import com.truper.saen.commons.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoTelDaoCache productoDao;
	
	@Override
	public Respuesta getAllProductos() {
		Respuesta respuesta = new Respuesta(); 
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | Tel.Productos  ");
		List<ProductoTel> productos = productoDao.findAllProductos();
		Date fin =  new Date();
		log.info("[FIN - SELECT] | Tel.Productos - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "productos", productos);
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}

	@Override
	public Respuesta getProductoById(String idProducto) {
		Respuesta respuesta = new Respuesta(); 
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | Tel.Productos  ");
		ProductoTel producto = productoDao.findProductoById(idProducto);
		
		if( producto == null ) {
			respuesta = new Respuesta(Mensajes.TIPO_WARNING.getMensaje(), Mensajes.MSG_NODATA.getMensaje(), "producto", producto);
			respuesta.setEstado(HttpStatus.NOT_FOUND);			
			return respuesta;
		}
		
		Date fin =  new Date();
		log.info("[FIN - SELECT] | Tel.Productos - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "producto", producto);
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}

	@Override
	public Respuesta recargarLista() {
		Respuesta respuesta = new Respuesta();
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | Tel.Productos  ");
		productoDao.recargarLista();
		Date fin =  new Date();
		log.info("[FIN - SELECT] | Tel.Productos - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "Status", "OK");
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}
	
}
