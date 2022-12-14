package com.truper.catalogo.saen.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.dto.CentroDTO;
import com.truper.catalogo.saen.dao.CentroDaoCache;
import com.truper.catalogo.saen.service.CentroService;
import com.truper.saen.commons.entities.CatCentro;
import com.truper.saen.commons.enums.Mensajes;
import com.truper.saen.commons.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CentroServiceImpl implements CentroService{

	@Autowired
	private CentroDaoCache centroDao;
	
	@Override
	public Respuesta getCentros() {
		
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | saen.CatCentros  ");
		List<CatCentro> centros = centroDao.findAllCentros();
		
		List<CentroDTO> centrosDTO = this.catCentroToCentroDTO(centros);
		
		Date fin =  new Date();
		log.info("[FIN - SELECT] | saen.CatCentros - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(),Mensajes.MSG_EXITO.getMensaje(),"centros", centrosDTO);
		
		respuesta.setEstado(HttpStatus.OK);
		
		return respuesta;
	}
	

	@Override
	public Respuesta getCentroById(String idCentro) {
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | saen.CatCentros  ");
		CatCentro centro = centroDao.findCentroById(idCentro);
		
		if( centro == null ) {
						
			respuesta = new Respuesta(Mensajes.TIPO_WARNING.getMensaje(), Mensajes.MSG_NODATA.getMensaje(), null, null);
			respuesta.setEstado(HttpStatus.NOT_FOUND);			
			return respuesta;
		}		
		
		CentroDTO centroDTO = new CentroDTO();
		
		centroDTO.setIdCentro(centro.getIdCentro());
		centroDTO.setDescripcion(centro.getDescripcion());
		
		Date fin =  new Date();
		log.info("[FIN - SELECT] | saen.CatCentros - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(),Mensajes.MSG_EXITO.getMensaje(),"centro", centro);
		
		respuesta.setEstado(HttpStatus.OK);
		
		return respuesta;
	}

	@Override
	public Respuesta recargarLista() {
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | saen.CatCentros   ");
		centroDao.recargarLista();
		Date fin =  new Date();
		log.info("[FIN - SELECT] | saen.CatCentros  - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "Status", "OK");
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}

	
	private List<CentroDTO> catCentroToCentroDTO(List<CatCentro> centros) {
		
		List<CentroDTO> centrosDto = new ArrayList<>();
		
		for (CatCentro centro : centros) {
			
			CentroDTO centroDTO = new CentroDTO();
			centroDTO.setIdCentro(centro.getIdCentro());
			centroDTO.setDescripcion(centro.getDescripcion());
			
			centrosDto.add(centroDTO);
			
		}
		
		return centrosDto;
		
	}
	
}
