package com.truper.catalogo.dto;

import com.truper.saen.commons.entities.CatPrioridades;

import lombok.Data;

@Data
public class PrioridadDTO {
	
	private Integer idPrioridad;
	private String descripcion;
	private String color;
	
	public PrioridadDTO(CatPrioridades e) {
		this.idPrioridad= e.getIdPrioridad();
		this.descripcion= e.getDescripcion();
		this.color = e.getColor();
	}

}
