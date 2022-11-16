package com.truper.catalogo.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.truper.catalogo.saen.dao.ProveedorSaeDao;
import com.truper.catalogo.tel.dao.ProveedorTelDao;
import com.truper.catalogo.tel.entities.ProveedorTel;
import com.truper.saen.commons.entities.Proveedor;
import com.truper.saen.commons.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ActualizarProveedor {

	@Autowired
	private ProveedorTelDao telDao;
	
	@Autowired
	private ProveedorSaeDao saeDao;
	
	@Value("${api.datasource.tel.prefijo}")
	private String prefijoProv;
	
	
	public void actualizarProveedores() {
		
		log.info("[INICIO] - Actualizacion de proveedores");
		Date inicio = new Date();
		List<ProveedorTel> proveedores = telDao.findAll();
		log.info("Total proveedores en TEL: " + proveedores.size());		
		log.info("Actualizando proveedores...");
		List<Proveedor> extProveedores = new ArrayList<Proveedor>();
		for (ProveedorTel provTel : proveedores) {
			
			Proveedor prov = saeDao.findById(provTel.getClaveProveedor()).orElse(null);
			
			if( prov == null ) {
				prov = new Proveedor();
			}
			
			prov.setClaveProveedor(provTel.getClaveProveedor());
			prov.setNombre(provTel.getNombreProveedor());
			prov.setEmail(provTel.getEmail());
			prov.setContacto(provTel.getContacto());
			prov.setRFC(provTel.getRFC());
			prov.setBloqueado(provTel.getBloqueado());
			extProveedores.add(prov);
			
		}		
		
		log.info("actualizando {} proveedores",extProveedores.size());
		
		saeDao.saveAll(extProveedores);
		
		Date fin = new Date();
		log.info("[FIN] - Actualizacion de proveedores finalizada; {} ",Utils.calcTiempoTranscurridoEnSegundos(inicio, fin));
	}
	
}
