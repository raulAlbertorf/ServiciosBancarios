package com.ibm.academia.cajerosautomaticos.models.dtos;

import lombok.Data;

@Data
public class ServicioBancarioDTO {

	private Integer id;
	private Integer tipoServicio;
	private String 	colonia;
	private String 	avenida;
	private String 	localidad;
	private Integer esquina;
	private String 	direccionEspannol;
	private String 	direccionIngles;
	private Integer radio;
	private Integer grupo;
	private String 	horaAbrir;
	private String  horaCerrar;
//	private Integer opcion2;
//	private String 	horaAbrir2;
//	private String  horaCerrar2; 
	private Long 	latitud;
	private Long 	longitud;
	private String 	estadoMexicano;
//	private Integer desconocido1;
	private String 	servicioDetalle;
//	private Integer desconocido2;
//	private Integer desconocido3;
	private Integer annio;
	

}
