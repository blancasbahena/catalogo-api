package com.truper.catalogo.saen.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.dto.CentroDTO;
import com.truper.catalogo.dto.PrioridadDTO;
import com.truper.catalogo.saen.dao.PrioridadDaoCache;
import com.truper.catalogo.saen.service.PrioridadService;
import com.truper.saen.commons.entities.CatCentro;
import com.truper.saen.commons.entities.CatPrioridades;
import com.truper.saen.commons.enums.Mensajes;
import com.truper.saen.commons.utils.Utils;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class PrioridadServiceImpl implements PrioridadService {
	
	@Autowired
	private PrioridadDaoCache prioridadDao;

	@Override
	public Respuesta getPrioridades() {
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | saen.prioridades  ");		
		List<PrioridadDTO> prioridadades =prioridadDao.findAllPrioridades().stream().map(e -> new PrioridadDTO(e)).collect(Collectors.toList());		
		Date fin =  new Date();
		log.info("[FIN - SELECT] | saen.prioridades - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(),Mensajes.MSG_EXITO.getMensaje(),"prioridadades", prioridadades);

		respuesta.setEstado(HttpStatus.OK);
		
		return respuesta;
	}

	@Override
	public Respuesta getPrioridadByTipo(String tipo) {
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | saen.getPrioridadByTipo  ");
		List<PrioridadDTO> prioridades =prioridadDao.findByTipo(tipo).stream().map(e -> new PrioridadDTO(e)).collect(Collectors.toList());		
		
		
		if( prioridades == null ) {
						
			respuesta = new Respuesta(Mensajes.TIPO_WARNING.getMensaje(), Mensajes.MSG_NODATA.getMensaje(), null, null);
			respuesta.setEstado(HttpStatus.NOT_FOUND);			
			return respuesta;
		}		
		
	
		
		Date fin =  new Date();
		log.info("[FIN - SELECT] | saen.getPrioridadByTipo - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(),Mensajes.MSG_EXITO.getMensaje(),"prioridad", prioridades);
		
		respuesta.setEstado(HttpStatus.OK);
		
		return respuesta;
	}
	

}
