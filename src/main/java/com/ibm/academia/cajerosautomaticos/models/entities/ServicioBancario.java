package com.ibm.academia.cajerosautomaticos.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class ServicioBancario {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tipo_servicio")
	private Integer tipoServicio;
	
	@Column(name = "colonia")
	private String 	colonia;
	
	@Column(name= "avenida")
	private String 	avenida;
	
	@Column(name= "localidad")
	private String 	localidad;
	
	@Column(name= "esquina")
	private Integer esquina;
	
	@Column(name= "direccion_español")
	private String 	direccionEspannol;
	
	@Column(name= "direccion_ingles")
	private String 	direccionIngles;
	
	@Column(name= "radio")
	private String radio;
	
	@Column(name= "grupo")
	private Integer grupo;
	
	@Column(name= "hora_abrir")
	private String 	horaAbrir;
	
	@Column(name= "hora_cerrar")
	private String  horaCerrar;
	
	@Column(name= "opcion2")
	private Integer opcion2;
	
	@Column(name= "hora_abrir_opc2")
	private String 	horaAbrir2;
	
	@Column(name= "hora_cerrar_opc2")
	private String  horaCerrar2; 
	
	@Column(name= "latitud")
	private Double 	latitud;
	
	@Column(name= "longitud")
	private Double 	longitud;
	
	@Column(name= "estado_mexicano")
	private String 	estadoMexicano;
	
	@Column(name= "desconocido1")
	private String desconocido1;
	
	@Column(name= "servicio_detalle")
	private String 	servicioDetalle;
	
	@Column(name = "desconocido2")
	private String desconocido2;
	
	@Column(name = "desconocido3")
	private String desconocido3;
	
	@Column(name = "annio")
	private String annio;
	
	
}
