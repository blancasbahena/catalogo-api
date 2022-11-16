package com.truper.catalogo.saen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.saen.dao.TiposUnidadDao;
import com.truper.catalogo.saen.service.TiposUnidadService;
import com.truper.saen.commons.entities.catTipoDeUnidad;
import com.truper.saen.commons.enums.Mensajes;

@Service
public class TiposUnidadServiceImpl implements TiposUnidadService{

	@Autowired
	private TiposUnidadDao unidadDao;
	
	@Override
	public Respuesta getTiposDeUnidad() {
		
		Respuesta respuesta;
		
		List<catTipoDeUnidad> tUnidad = unidadDao.findAll();
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(),Mensajes.MSG_EXITO.getMensaje(),"tiposUnidad", tUnidad);
		
		respuesta.setEstado(HttpStatus.OK);
		
		return respuesta;

	}

}
