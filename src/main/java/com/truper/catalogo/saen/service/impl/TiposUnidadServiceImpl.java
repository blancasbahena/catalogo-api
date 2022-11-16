package com.truper.catalogo.saen.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.saen.dao.TiposUnidadDaoCache;
import com.truper.catalogo.saen.service.TiposUnidadService;
import com.truper.saen.commons.entities.CatTipoDeUnidad;
import com.truper.saen.commons.enums.Mensajes;
import com.truper.saen.commons.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TiposUnidadServiceImpl implements TiposUnidadService{

	@Autowired
	private TiposUnidadDaoCache unidadDao;
	
	@Override
	public Respuesta getTiposDeUnidad() {
		
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | saen.catTiposDeUnidad  ");
		List<CatTipoDeUnidad> tUnidad = unidadDao.findAllTiposUnidad();
		Date fin =  new Date();
		log.info("[FIN - SELECT] | saen.catTiposDeUnidad - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(),Mensajes.MSG_EXITO.getMensaje(),"tiposUnidad", tUnidad);
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;

	}

	@Override
	public Respuesta getTipoUnidadById(Integer idTipoUnidad) {

		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | saen.catTiposDeUnidad  ");
		CatTipoDeUnidad tUnidad = unidadDao.findTipoUnidadById(idTipoUnidad);
		Date fin =  new Date();
		log.info("[FIN - SELECT] | saen.catTiposDeUnidad - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
				
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(),Mensajes.MSG_EXITO.getMensaje(),"tipoUnidad", tUnidad);
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
		
	}

	@Override
	public Respuesta recargarLista() {
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | saen.catTiposDeUnidad  ");
		unidadDao.recargarLista();
		Date fin =  new Date();
		log.info("[FIN - SELECT] | saen.catTiposDeUnidad - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "Status", "OK");
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}

}
