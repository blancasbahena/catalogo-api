package com.truper.catalogo.tel.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.tel.dao.PlaneadorTelDaoCache;
import com.truper.catalogo.tel.dao.ProveedorTelDaoCache;
import com.truper.catalogo.tel.entities.PlaneadorTel;
import com.truper.catalogo.tel.entities.ProveedorTel;
import com.truper.catalogo.tel.entities.UsuariosTel;
import com.truper.catalogo.tel.service.PlaneadorService;
import com.truper.catalogo.tel.service.ProveedorService;
import com.truper.saen.commons.enums.Mensajes;
import com.truper.saen.commons.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlaneadorServiceImpl implements PlaneadorService{

	@Autowired
	private PlaneadorTelDaoCache telDao;

	
	@Override
	public Respuesta getPlaneadoresTel() {		
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | Tel.ImportacionesProveedores  ");
		List<PlaneadorTel> proveedores = telDao.findPlaneador();
		Date fin =  new Date();
		log.info("[FIN - SELECT] | Tel.ImportacionesProveedores - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "planeadores", proveedores);
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}
	
	@Override
	public Respuesta getPlaneadoresbyList(List<String> planners) {		
		Respuesta respuesta;
		Date inicio =  new Date();
		log.info("[INICIO - SELECT] | Tel.ImportacionesProveedores  ");
		List<PlaneadorTel> proveedores = new ArrayList<PlaneadorTel>();
		for(String planner:planners) {
			PlaneadorTel plannerG= telDao.findPlaneadorById(planner);
			proveedores.add(plannerG);
			
		}
		
		Date fin =  new Date();
		log.info("[FIN - SELECT] | Tel.ImportacionesProveedores - {}" ,Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "proveedores", proveedores);
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
