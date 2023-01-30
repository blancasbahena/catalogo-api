package com.truper.catalogo.tel.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ImportacionesPlaneadores")
@Getter @Setter
public class PlaneadorTel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusr")
    private String idusr;

    @Column(name = "codigoPlaneador")
    private String codigoPlaneador;

    @Column(name = "email")
    private String email;
    
    @Column(name = "realUser")
    private String realUser;
    
    @Column(name = "idGerente")
    private String idGerente;   
    
    @OneToOne
	@JoinColumn(name = "idusr")
	private UsuariosTel user;
    
}
