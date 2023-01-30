package com.truper.catalogo.tel.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Usuarios")
@Getter @Setter
public class UsuariosTel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "pwd")
    private Long pwd;
    
    @Column(name = "cambiar")
    private Long cambiar;
    
    @Column(name = "ipcambio")
    private String ipcambio;
    
    @Column(name = "ultimoCambio")
    private Date ultimoCambio;
    
    @Column(name = "ped")
    private Long ped;
    
    @Column(name = "noborrar")
    private Long noborrar;
    
    @Column(name = "expo")
    private Long expo;
    
    @Column(name = "bloqueado")
    private Long bloqueado;
    
    @Column(name = "vistasplus")
    private Long vistasplus;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "ingresos")
    private Long ingresos;
    
    @Column(name = "credito")
    private Long credito;
    
    @Column(name = "creaobj")
    private Long creaobj;
    
    @Column(name = "modobj")
    private Long modobj;
    
    @Column(name = "ultAcceso")
    private Date ultAcceso;
    
    @Column(name = "cteBorrado")
    private Long cteBorrado;
    
    @Column(name = "vtaDiaria")
    private Long vtaDiaria;
    
    @Column(name = "renglonaje")
    private Long renglonaje;
    
    @Column(name = "existencias")
    private Long existencias;
    
    @Column(name = "consultRefac")
    private Long consultRefac;
    
    @Column(name = "nobloqbo")
    private Long nobloqbo;
    
    @Column(name = "aplicapagos")
    private Long aplicapagos;
    
    @Column(name = "exportaciones")
    private Long exportaciones;
    
    @Column(name = "truput")
    private Long truput;
    
    @Column(name = "verPorFactMont")
    private Long verPorFactMont;
    
    @Column(name = "modFechasArrivoProd")
    private Long modFechasArrivoProd;
    
    @Column(name = "comprasImport")
    private Long comprasImport;
    
    @Column(name = "gerVirtual")
    private Long gerVirtual;
    
    @Column(name = "pendientes")
    private Long pendientes;
    
    @Column(name = "verEficienciaUsoImportaciones")
    private Long verEficienciaUsoImportaciones;
    
    @Column(name = "superUsrPedSpecialNewProds")
    private Long superUsrPedSpecialNewProds;
    
    @Column(name = "canAssignBrandSupport")
    private Long canAssignBrandSupport;
    
    @Column(name = "userEmail")
    private String userEmail;
    
    @Column(name = "regOCyProforma")
    private Long regOCyProforma;
    
    @Column(name = "brandSupportCredit")
    private Long brandSupportCredit;
    
    @Column(name = "verpendientes")
    private Long verpendientes;
    
    @Column(name = "gerSucursal")
    private String gerSucursal;
    
    @Column(name = "modPronMrp")
    private Long modPronMrp;
    
    @Column(name = "semaforoZona")
    private Long semaforoZona;
    
    @Column(name = "lastPoll")
    private String lastPoll;
    
    @Column(name = "numemp")
    private String numemp;
    
    @Column(name = "pwdingreso")
    private Long pwdingreso;
    
    @Column(name = "lang")
    private String lang;
    
    @Column(name = "forceArrival")
    private Long forceArrival;
    
    @Column(name = "truputNac")
    private Long truputNac;
    
    @Column(name = "truputLat")
    private Long truputLat;
    
    @Column(name = "esGerente")
    private Long esGerente;
    
    @Column(name = "esDirector")
    private Long esDirector;
    
    @Column(name = "esPlaneador")
    private Long esPlaneador;
    
    @Column(name = "userDevoluciones")
    private String userDevoluciones;
    
    @Column(name = "esAuditor")
    private Long esAuditor;
    
    @Column(name = "calificaBono")
    private Long calificaBono;
    
    @Column(name = "pwdMd5")
    private String pwdMd5;
    
    @Column(name = "pwd2Md5")
    private String pwd2Md5;
    
    @Column(name = "cobranza")
    private Long cobranza;
    
    @Column(name = "condicionesEspeciales")
    private Long condicionesEspeciales;
    
    @Column(name = "modificaCondiciones")
    private Long modificaCondiciones;
    
    @Column(name = "superUsrPedSpecialNewStore")
    private Long superUsrPedSpecialNewStore;
    
    @Column(name = "truputUSA")
    private Long truputUSA;
    
    @Column(name = "cargaArchivosCostos")
    private Long cargaArchivosCostos;
    
    @Column(name = "veBonoServicio")
    private Long veBonoServicio;
    @Column(name = "usuarioSecundario")
    private Long usuarioSecundario;
    @Column(name = "superUsrPedR24")
    private Long superUsrPedR24;
    @Column(name = "bloqCapturaVisitas")
    private Long bloqCapturaVisitas;
    @Column(name = "impTruputNeto")
    private Long impTruputNeto;
    @Column(name = "compIngAsesores")
    private Long compIngAsesores;
    
    @Column(name = "enCambioDePwd")
    private Long enCambioDePwd;
    @Column(name = "juntaTrimestral")
    private Long juntaTrimestral;
    @Column(name = "pronosticoPorCliente")
    private Long pronosticoPorCliente;
    @Column(name = "editEvalTrimGtes")
    private Long editEvalTrimGtes;
    @Column(name = "fechasPO")
    private Long fechasPO;
    @Column(name = "verDrp")
    private Long verDrp;
    @Column(name = "comisionista")
    private Long comisionista;
    
    @Column(name = "formatosBO")
    private Long formatosBO;
    @Column(name = "capturaPubliservicios")
    private Long capturaPubliservicios;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "ua1")
    private String ua1;
    @Column(name = "ua2")
    private String ua2;
    @Column(name = "ua3")
    private String ua3;
    @Column(name = "acceso1equipo")
    private Long acceso1equipo;
    @Column(name = "userAtipicosCallCenter")
    private Long userAtipicosCallCenter;
    
    @Column(name = "userAtipicosSucursal")
    private Long userAtipicosSucursal;
    @Column(name = "superUsrPedApoyoMarca")
    private Long superUsrPedApoyoMarca;
    @Column(name = "pruebasBeta")
    private Long pruebasBeta;
    @Column(name = "mostropolitica")
    private Long mostropolitica;
    @Column(name = "partMarcas")
    private Long partMarcas;
    @Column(name = "pronosticoPorClienteLC")
    private Long pronosticoPorClienteLC;
    @Column(name = "verCargaProdFabricados")
    private Long verCargaProdFabricados;
    @Column(name = "tipoProdMarcaAtipicos")
    private String tipoProdMarcaAtipicos;
    @Column(name = "csvVentaDiaria")
    private Long csvVentaDiaria;
    @Column(name = "csvSucVentaDiaria")
    private Long csvSucVentaDiaria;
    @Column(name = "veInterplantas")
    private Long veInterplantas;
    @Column(name = "notitruper")
    private Long notitruper;
    @Column(name = "autProsEspMs")
    private Long autProsEspMs;
    @Column(name = "vistaPromociones")
    private Long vistaPromociones;
    @Column(name = "vistaRotulaciones")
    private Long vistaRotulaciones;
    @Column(name = "vistaVariacionesConsumo")
    private Long vistaVariacionesConsumo;
    @Column(name = "superUsrTopePed")
    private Long superUsrTopePed;
    @Column(name = "vMarca")
    private String vMarca;
    
    @Column(name = "moduloAtipicosDRP")
    private Long moduloAtipicosDRP;
    @Column(name = "veBotonUlt10Ctes")
    private Long veBotonUlt10Ctes;
    @Column(name = "userManuales")
    private Long userManuales;
    @Column(name = "ayuda")
    private Long ayuda;
    @Column(name = "ayudaTecnica")
    private Long ayudaTecnica;
    @Column(name = "isProveedor")
    private Long isProveedor;
    @Column(name = "zonas")
    private String zonas;
    @Column(name = "controlAcceso")
    private Long controlAcceso;
    @Column(name = "levantaIncidentesTransporte")
    private Long levantaIncidentesTransporte;
    @Column(name = "sucIncidentes")
    private String sucIncidentes;
    @Column(name = "veDetallesFacBO")
    private Long veDetallesFacBO;
    @Column(name = "superUsuarioIncidentes")
    private Long superUsuarioIncidentes;
    
    @Column(name = "vistaManoNegra")
    private Long vistaManoNegra;
    @Column(name = "vista_foliosDeRefacciones")
    private Long vista_foliosDeRefacciones;
    @Column(name = "cargaEscasos")
    private Long cargaEscasos;
    @Column(name = "sucIncidentesTransporte")
    private String sucIncidentesTransporte;
    @Column(name = "fechaBaja")
    private Long fechaBaja;
    @Column(name = "fechaAlta")
    private Long fechaAlta;
    @Column(name = "truputRM")
    private Long truputRM;
    @Column(name = "pwd_sha256")
    private String pwd_sha256;
    @Column(name = "proteccionSS")
    private Long proteccionSS;
    

    
	
}
