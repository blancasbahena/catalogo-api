package com.truper.catalogo.tel.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.truper.catalogo.commons.Respuesta;
import com.truper.catalogo.tel.dao.FamiliasTelDaoCache;
import com.truper.catalogo.tel.dao.PlaneadorTelDaoCache;
import com.truper.catalogo.tel.dao.ProveedorTelDaoCache;
import com.truper.catalogo.tel.entities.Familias;
import com.truper.catalogo.tel.entities.PlaneadorTel;
import com.truper.catalogo.tel.entities.ProveedorTel;
import com.truper.catalogo.tel.entities.UsuariosTel;
import com.truper.catalogo.tel.service.FamiliasService;
import com.truper.catalogo.tel.service.PlaneadorService;
import com.truper.catalogo.tel.service.ProveedorService;
import com.truper.saen.commons.enums.Mensajes;
import com.truper.saen.commons.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FamiliasServiceImpl implements FamiliasService {

	@Autowired
	private FamiliasTelDaoCache familiasTelDaoCache;

	@Override
	public Respuesta getFamilias() {
		Respuesta respuesta;
		Date inicio = new Date();
		log.info("[INICIO - SELECT] | Tel.familiasTelDaoCache  ");
		List<Familias> proveedores = familiasTelDaoCache.findFamilias();
		Date fin = new Date();
		log.info("[FIN - SELECT] | Tel.familiasTelDaoCache - {}",
				Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "familias",
				proveedores);
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}

	@Override
	public Respuesta getFamilia(String codigo) {
		Respuesta respuesta;
		Date inicio = new Date();
		log.info("[INICIO - SELECT] | Tel.familiasTelDaoCache  ");
		Familias family = familiasTelDaoCache.findFamiliaByID(codigo);
		Date fin = new Date();
		log.info("[FIN - SELECT] | Tel.familiasTelDaoCache - {}",
				Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "familias",
				family);
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}

	@Override
	public Respuesta recargarLista() {
		Respuesta respuesta;
		Date inicio = new Date();
		log.info("[INICIO - SELECT] | Tel.familiasTelDaoCache  ");
		familiasTelDaoCache.recargarLista();
		Date fin = new Date();
		log.info("[FIN - SELECT] | Tel.familiasTelDaoCache - {}",
				Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));

		respuesta = new Respuesta(Mensajes.TIPO_EXITO.getMensaje(), Mensajes.MSG_EXITO.getMensaje(), "Status", "OK");
		respuesta.setEstado(HttpStatus.OK);
		return respuesta;
	}

}
