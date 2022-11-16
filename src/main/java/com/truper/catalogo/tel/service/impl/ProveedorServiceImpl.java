package com.truper.catalogo.tel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.tel.dao.ProveedorTelDaoCache;
import com.truper.catalogo.tel.entities.ProveedorTel;
import com.truper.catalogo.tel.service.ProveedorService;
import com.truper.saen.commons.enums.Mensajes;

@Service
public class ProveedorServiceImpl implements ProveedorService{

	@Autowired
	private ProveedorTelDaoCache telDao;
	
	@Override
	public Respuesta getProveedoresTel() {		
		Respuesta respuesta;
		
		List<ProveedorTel> proveedores = telDao.findAllProveedores();
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "proveedores", proveedores);
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}
	


	@Override
	public Respuesta getProveedoresTelImportacion() {
		Respuesta respuesta;
		
		List<ProveedorTel> proveedores = telDao.findProveedoresImportacion();
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "proveedores", proveedores);
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}


	@Override
	public Respuesta getProveedorById(String idProveedor) {
		Respuesta respuesta;
		
		ProveedorTel proveedor = telDao.findProveedorById(idProveedor);
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "proveedor", proveedor);
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}

	
	
}
