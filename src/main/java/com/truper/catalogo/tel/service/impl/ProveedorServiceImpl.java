package com.truper.catalogo.tel.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.tel.dao.ProveedorTelDaoCache;
import com.truper.catalogo.tel.entities.ProveedorTel;
import com.truper.catalogo.tel.service.ProveedorService;
import com.truper.saen.commons.enums.Mensajes;
import com.truper.saen.commons.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	private ProveedorTelDaoCache telDao;

	
	@Override
	public Respuesta getProveedoresTel() {		
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | Tel.ImportacionesProveedores  ");
		List<ProveedorTel> proveedores = telDao.findAllProveedores();
		Date fin =  new Date();
		log.info("[FIN - SELECT] | Tel.ImportacionesProveedores - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "proveedores", proveedores);
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}
	


	@Override
	public Respuesta getProveedoresTelImportacion() {
		Respuesta respuesta;
		
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | Tel.ImportacionesProveedores  ");
		List<ProveedorTel> proveedores = telDao.findProveedoresImportacion();
		Date fin =  new Date();
		log.info("[FIN - SELECT] | Tel.ImportacionesProveedores - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "proveedores", proveedores);
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}


	@Override
	public Respuesta getProveedorById(String idProveedor) {
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | Tel.ImportacionesProveedores  ");
		ProveedorTel proveedor = telDao.findProveedorById(idProveedor);
		Date fin =  new Date();
		log.info("[FIN - SELECT] | Tel.ImportacionesProveedores - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		if( proveedor == null ) {
			respuesta = new Respuesta(Mensajes.TIPO_WARNING.getMensaje(), Mensajes.MSG_NODATA.getMensaje(), "proveedor", proveedor);
			respuesta.setEstado(HttpStatus.NOT_FOUND);			
			return respuesta;
		}
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "proveedor", proveedor);
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}



	@Override
	public Respuesta recargarLista() {
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | Tel.ImportacionesProveedores  ");
		telDao.recargarLista();
		Date fin =  new Date();
		log.info("[FIN - SELECT] | Tel.ImportacionesProveedores - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "Status", "OK");
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}

	
	
}
