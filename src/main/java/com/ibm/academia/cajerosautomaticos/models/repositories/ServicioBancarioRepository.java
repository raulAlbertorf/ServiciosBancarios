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
	
	@Query("Select s From ServicioBancario s WHERE (upper(s.colonia) like upper(concat('%', ?1,'%')) or "
			+ "upper(s.avenida) like upper(concat('%', ?1,'%')) or upper(s.localidad) like upper(concat('%', ?1,'%')) or "
			+ "upper(s.direccionEspannol) like upper(concat('%', ?1,'%')) or upper(s.direccionIngles) like upper(concat('%', ?1,'%'))) "
			+ "and upper(s.localidad) like upper(concat('%', ?2,'%')) and upper(s.estadoMexicano) like upper(concat('%', ?3,'%'))")
	public List<ServicioBancario> buscarPorLugarCPEstado(String lugar, String codigoPostal, String estado);
	
	@Query("Select s From ServicioBancario s WHERE upper(s.localidad) like upper(concat('%', ?2,'%')) and upper(s.estadoMexicano) = upper(?3) and upper(s.servicioDetalle) = upper(?4) and "
			+ "(upper(s.colonia) like upper(concat('%', ?1,'%')) or "
			+ "upper(s.avenida) like upper(concat('%', ?1,'%')) or upper(s.localidad) like upper(concat('%', ?1,'%')) or "
			+ "upper(s.direccionEspannol) like upper(concat('%', ?1,'%')) or upper(s.direccionIngles) like upper(concat('%', ?1,'%'))) ")
	public List<ServicioBancario> buscarPorLugarCPEstadoServicio(String lugar, String codigoPostal, String estado, String servicio);
	public List<ServicioBancario> findByServicioDetalle(String servicioDetalle);
	
	@Query("Select distinct concat(s.tipoServicio, ' - ', s.servicioDetalle) From ServicioBancario s")
	public List<String> listarServicios();
	
}
