package com.truper.catalogo.saen.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.saen.dao.CentroDao;
import com.truper.catalogo.saen.dao.CentroDaoCache;
import com.truper.catalogo.saen.service.CentroService;
import com.truper.saen.commons.entities.CatCentro;
import com.truper.saen.commons.enums.Mensajes;

@Service
public class CentroServiceImpl implements CentroService{

	@Autowired
	private CentroDaoCache centroDao;
	
	@Override
	public Respuesta getCentros() {
		
		Respuesta respuesta;
		
		List<CatCentro> centros = centroDao.findAllCentros();
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(),Mensajes.MSG_EXITO.getMensaje(),"centros", centros);
		
		respuesta.setEstado(HttpStatus.OK);
		
		return respuesta;
	}

}
