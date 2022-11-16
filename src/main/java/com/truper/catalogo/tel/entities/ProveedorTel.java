package com.truper.catalogo.tel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ImportacionesProveedores")
@Getter @Setter
public class ProveedorTel {

    @Id
    @Column(name = "claveProveedor",length = 6)
    private String claveProveedor;

    @Column(name = "nombreProveedor",length = 80)
    private String nombreProveedor;

    @Column(name = "email",length = 132)
    private String email;
    
    @Column(name = "contacto",length = 15)
    private String contacto;
    
    @Column(name = "rfc", length = 30)
    private String RFC;
    
    @JsonIgnore
    @Column(name = "bloqueado")
    private Boolean bloqueado;
	
}
