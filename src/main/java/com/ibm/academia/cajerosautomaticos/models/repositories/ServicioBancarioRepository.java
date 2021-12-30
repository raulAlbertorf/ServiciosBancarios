package com.ibm.academia.cajerosautomaticos.models.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.cajerosautomaticos.models.entities.ServicioBancario;

@Repository
public interface ServicioBancarioRepository extends CrudRepository<ServicioBancario, Integer>{

	public Optional<ServicioBancario> findById(Integer id);
	public List<ServicioBancario> findByTipoServicio(Integer tipoServicio);
	@Query("Select s From ServicioBancario s WHERE upper(s.colonia) like upper(concat('%', ?1,'%')) or "
			+ "upper(s.avenida) like upper(concat('%', ?1,'%')) or upper(s.localidad) like upper(concat('%', ?1,'%')) or "
			+ "upper(s.direccionEspannol) like upper(concat('%', ?1,'%')) or upper(s.direccionIngles) like upper(concat('%', ?1,'%'))")
	public List<ServicioBancario> buscarPorLugar(String lugar);
	
	@Query("Select s From ServicioBancario s WHERE s.direccionEspannol like %?1%")
	public List<ServicioBancario> buscarPorDireccionEspannol(String direccionEspannol);
	
	@Query("Select s From ServicioBancario s WHERE (upper(s.colonia) like upper(concat('%', ?1,'%')) or "
			+ "upper(s.avenida) like upper(concat('%', ?1,'%')) or upper(s.localidad) like upper(concat('%', ?1,'%')) or "
			+ "upper(s.direccionEspannol) like upper(concat('%', ?1,'%')) or upper(s.direccionIngles) like upper(concat('%', ?1,'%'))) "
			+ "and upper(s.localidad) like upper(concat('%', ?2,'%')) and upper(s.estadoMexicano) like upper(concat('%', ?3,'%'))")
	public List<ServicioBancario> buscarPorLugarCPEstado(String lugar, String codigoPostal, String estado);
	
	@Query("Select s From ServicioBancario s WHERE (upper(s.colonia) like upper(concat('%', ?1,'%')) or "
			+ "upper(s.avenida) like upper(concat('%', ?1,'%')) or upper(s.localidad) like upper(concat('%', ?1,'%')) or "
			+ "upper(s.direccionEspannol) like upper(concat('%', ?1,'%')) or upper(s.direccionIngles) like upper(concat('%', ?1,'%'))) "
			+ "and upper(s.localidad) like upper(concat('%', ?2,'%')) and upper(s.estadoMexicano) like upper(concat('%', ?3,'%')) and upper(s.servicioDetalle) like upper(concat('%', ?4,'%'))")
	public List<ServicioBancario> buscarPorLugarCPEstadoServicio(String lugar, String codigoPostal, String estado, String servicio);
	
	
	
//	private Integer id;
//	private Integer tipoServicio;
//	private String 	colonia;
//	private String 	avenida;
//	private String 	localidad;
//	private Integer esquina;
//	private String 	direccionEspannol;
//	private String 	direccionIngles;
//	private Integer radio;
//	private Integer grupo;
//	private String 	horaAbrir;
//	private String  horaCerrar;
////	private Integer opcion2;
////	private String 	horaAbrir2;
////	private String  horaCerrar2; 
//	private Long 	latitud;
//	private Long 	longitud;
//	private String 	estadoMexicano;
////	private Integer desconocido1;
//	private String 	servicioDetalle;
////	private Integer desconocido2;
////	private Integer desconocido3;
//	private Integer annio;
}
