package com.ibm.academia.cajerosautomaticos.models.servicies;

import java.util.List;
import java.util.Optional;

import com.ibm.academia.cajerosautomaticos.models.entities.ServicioBancario;

public interface ServicioBancarioService {
	public void cargaServiciosBancarios(StringBuilder jsonP);
	public Optional<ServicioBancario> findById(Integer id);
	public List<ServicioBancario> findByTipoServicio(Integer tipoServicio);
	public List<ServicioBancario> buscarPorLugar(String lugar);
	public List<ServicioBancario> buscarPorLugarCPEstado(String lugar, String codigoPostal, String estado);
	public List<ServicioBancario> buscarPorLugarCPEstadoServicio(String lugar, String codigoPostal, String estado, String servicio);
	public List<ServicioBancario> findByServicioDetalle(String servicioDetalle);
	public List<String> listarServicios();
}
