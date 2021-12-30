package com.ibm.academia.cajerosautomaticos.models.mappers;

import java.util.List;

import com.ibm.academia.cajerosautomaticos.models.entities.ServicioBancario;

public class ServicioBancarioMapper {
	
	public static ServicioBancario mapServicioBancario(List<String> item) {
		ServicioBancario servicio = new ServicioBancario();
		servicio.setId(Integer.parseInt(item.get(0)));
		servicio.setTipoServicio(Integer.parseInt(item.get(1)));
		servicio.setColonia(item.get(2));
		servicio.setAvenida(item.get(3));
		servicio.setLocalidad(item.get(4));
		servicio.setEsquina(Integer.parseInt(item.get(5)));
		servicio.setDireccionEspannol(item.get(6));
		servicio.setDireccionIngles(item.get(7));
		servicio.setRadio(item.get(8));
		servicio.setGrupo(Integer.parseInt(item.get(9)));
		servicio.setHoraAbrir(item.get(10));
		servicio.setHoraCerrar(item.get(11));
		servicio.setOpcion2(Integer.parseInt(item.get(12)));
		servicio.setHoraAbrir2(item.get(13));
		servicio.setHoraCerrar2(item.get(14));
		servicio.setLatitud(Double.parseDouble(item.get(15)));
		servicio.setLongitud(Double.parseDouble(item.get(16)));
		servicio.setEstadoMexicano(item.get(17));
		servicio.setDesconocido1(item.get(18));
		servicio.setServicioDetalle(item.get(19));
		servicio.setDesconocido2(item.get(20));
		servicio.setDesconocido3(item.get(21));
		servicio.setAnnio(item.get(22));		
		return servicio;
	}

}
