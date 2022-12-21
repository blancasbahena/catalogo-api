package com.truper.catalogo.saen.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.dto.SucursalDTO;
import com.truper.catalogo.saen.dao.CentroDaoCache;
import com.truper.catalogo.saen.service.SucursalesService;
import com.truper.saen.commons.entities.CatCentro;
import com.truper.saen.commons.enums.Mensajes;
import com.truper.saen.commons.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SucursalServiceImpl implements SucursalesService{

	@Autowired
	private CentroDaoCache sucursalDao;
	
	@Override
	public Respuesta getSucursales() {
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | saen.catSucursales  ");
		List<CatCentro> sucursales = sucursalDao.findAllSucursales();
		List<SucursalDTO> sucursalesDTO = this.sucursalToSucursalDTO(sucursales);
		Date fin =  new Date();
		log.info("[FIN - SELECT] | saen.catSucursales - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(),Mensajes.MSG_EXITO.getMensaje(),"sucursales", sucursalesDTO);
		respuesta.setEstado(HttpStatus.OK);
		
		return respuesta;
	}

	@Override
	public Respuesta getSucursalById(String idSucursal) {
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | saen.catSucursales  ");
		CatCentro sucursal = sucursalDao.findSucursalById(idSucursal);
		Date fin =  new Date();
		log.info("[FIN - SELECT] | saen.catSucursales - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		if( sucursal == null ) {
			respuesta = new Respuesta(Mensajes.TIPO_WARNING.getMensaje(), Mensajes.MSG_NODATA.getMensaje(), null, null);
			respuesta.setEstado(HttpStatus.NOT_FOUND);			
			return respuesta;
		}

		SucursalDTO sucDto = new SucursalDTO();
		sucDto.setIdSucursal(sucursal.getIdCentro());
		sucDto.setDescripcion(sucursal.getDescripcion());

		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(),Mensajes.MSG_EXITO.getMensaje(),"sucursal", sucDto);
		respuesta.setEstado(HttpStatus.OK);
		
		return respuesta;
	}

	@Override
	public Respuesta recargarLista() {
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | saen.catSucursales   ");
		sucursalDao.recargarLista();
		Date fin =  new Date();
		log.info("[FIN - SELECT] | saen.catSucursales  - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "Status", "OK");
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}
	
	private List<SucursalDTO> sucursalToSucursalDTO( List<CatCentro> sucursales){
		
		List<SucursalDTO> sucursalesDto = new ArrayList<>();
		
		for (CatCentro sucursal : sucursales) {
			
			SucursalDTO sucDto = new SucursalDTO();
			sucDto.setIdSucursal(sucursal.getIdCentro());
			sucDto.setDescripcion(sucursal.getDescripcion());
			
			sucursalesDto.add(sucDto);
			
		}
		
		return sucursalesDto;
	}
	
}
