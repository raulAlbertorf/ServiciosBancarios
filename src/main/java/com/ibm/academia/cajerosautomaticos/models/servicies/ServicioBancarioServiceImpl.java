package com.ibm.academia.cajerosautomaticos.models.servicies;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.academia.cajerosautomaticos.models.entities.ServicioBancario;
import com.ibm.academia.cajerosautomaticos.models.mappers.ServicioBancarioMapper;
import com.ibm.academia.cajerosautomaticos.models.repositories.ServicioBancarioRepository;

@Service
public class ServicioBancarioServiceImpl implements ServicioBancarioService {

	Logger log = LoggerFactory.getLogger(ServicioBancarioServiceImpl.class);

	@Autowired
	private ServicioBancarioRepository repository;

	@Override
	public void cargaServiciosBancarios(StringBuilder jsonP) {
		log.info("Inicia carga en base de datos - Servicios Bancarios");
		Integer abre = jsonP.indexOf("[");
		Integer cierra = jsonP.indexOf("]", abre + 1);
		LinkedList<ServicioBancario> servicios = new LinkedList<ServicioBancario>();
		while (abre > 0 && cierra > 0) {
			 List<String> servicio = Arrays.asList(jsonP.substring(abre + 1, cierra).split("\",\"")).stream()
					.map(item -> item.replace("\"", "")).collect(Collectors.toList());
			 
			servicios.add(ServicioBancarioMapper.mapServicioBancario(servicio));
			jsonP.delete(0, cierra);
			abre = jsonP.indexOf("[");
			cierra = jsonP.indexOf("]", abre + 1);
		}
		Iterable<ServicioBancario> iterableServicios = servicios;
		repository.saveAll(iterableServicios);
		log.info("Termina exitosamente carga en base de datos - Servicios Bancarios");
	}

	@Override
	public Optional<ServicioBancario> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<ServicioBancario> findByTipoServicio(Integer tipoServicio) {
		return repository.findByTipoServicio(tipoServicio);
	}

	@Override
	public List<ServicioBancario> buscarPorLugar(String lugar) {
		return repository.buscarPorLugar(lugar);
	}

	@Override
	public List<ServicioBancario> buscarPorLugarCPEstado(String lugar, String codigoPostal, String estado) {
		return repository.buscarPorLugarCPEstado(lugar, "C.P. "+codigoPostal, estado);
	}

	@Override
	public List<ServicioBancario> buscarPorLugarCPEstadoServicio(String lugar, String codigoPostal, String estado,
			String servicio) {
		return repository.buscarPorLugarCPEstadoServicio(lugar, "C.P. "+codigoPostal, estado, servicio);
	}

	@Override
	public List<ServicioBancario> findByServicioDetalle(String servicioDetalle) {
		return repository.findByServicioDetalle(servicioDetalle);
	}

	@Override
	public List<String> listarServicios() {
		return repository.listarServicios();
	}
	

}
