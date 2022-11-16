package com.truper.catalogo.tel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class ProductoTel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -405047508255478002L;
	
	@Id
    @Column(name = "codigo", length = 15)
    private String codigo;

    @Column(name = "clave",length = 20)
    private String clave;

    @Column(name = "descripcion", length = 100)
    private String descripcion;
    
    @JsonIgnore
    @Column()
    private Boolean obsoleto;
    
    @Column()
    @JsonIgnore
    private Boolean refaccion;

    @Column(name = "masterCart")
    private Integer masterCart;

    @Column(name = "volumenCart")
    private Double volumenCart;

    @Column(name = "pesoCart")
    private Double pesoCart;
    
    @Column(name = "pesoMaster")
    private Double pesoMaster;

    @Column(name = "volumenMaster")
    private Double volumenMaster;
    
    @Column(name ="productoOEM")
    private Boolean productoOEM;

}
