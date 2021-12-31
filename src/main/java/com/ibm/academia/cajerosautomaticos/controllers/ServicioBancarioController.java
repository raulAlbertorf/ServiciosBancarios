package com.ibm.academia.cajerosautomaticos.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ibm.academia.cajerosautomaticos.models.entities.ServicioBancario;
import com.ibm.academia.cajerosautomaticos.models.servicies.ServicioBancarioService;

@RestController
@RequestMapping("/servicio")
public class ServicioBancarioController {

	Logger log = LoggerFactory.getLogger(ServicioBancarioController.class);

	@Autowired
	private RestTemplate clienteRest;

	@Autowired
	private ServicioBancarioService bancarioService;

	/**
	 * Endpoint para cargar/actualizar base de datos con respecto a API de Servicios Bancarios de Banamex
	 * @return Estatus Exitoso
	 * @BadRequest En caso de cualquier falla en proceso de carga/actualizacion
	 * @author RaulRuvalcaba 31/12/2021
	 */
	@PostMapping("/carga/servicios")
	public ResponseEntity<?> cargaServiciosBancarios() {
		try {
			String uri = "https://www.banamex.com/localizador/jsonP/json5.json";
			StringBuilder json = new StringBuilder(clienteRest.getForObject(uri, String.class));
			bancarioService.cargaServiciosBancarios(json);
		} catch (Exception e) {
			log.info("Error al cargar base de datos - Servicios Bancarios" + e.getMessage());
			return ResponseEntity.badRequest().body("Error al cargar base de datos - Servicios Bancarios");
		}
		return ResponseEntity.ok("Exitoso");
	}
	
	/**
	 * Endpoint para buscar cualquier servicio bancario con la palabra "lugar" contenida en la unibicación del servicio
	 * @param lugar Cadena contenida en ubicación del servicio
	 * @return Lista de Servicios Bancarios encontrados con palabra contenida en su ubicación
	 * @author RaulRuvalcaba 31/12/2021
	 */
	@GetMapping("/buscar")
	public ResponseEntity<?> buscarServicioPorLugar(@RequestParam String lugar){
		List<ServicioBancario> servicios = bancarioService.buscarPorLugar(lugar);
		return new ResponseEntity<List<ServicioBancario>>(servicios, HttpStatus.OK);
	}
	
	/**
	 * Endpoint para buscar Servicios Bancarios Banamex disponibles en el Lugar, Codigo Postal y Estado
	 * @param lugar Ubicación de la sucursal
	 * @param codigoPostal  
	 * @param estado 
	 * @return Lista de Servicios Bancarios Banamex encontrados en el lugar con codigo postal y el estado ingresado
	 * @author RaulRuvalcaba 31/12/2021
	 */
	@GetMapping("/buscar/lugar/codigoPostal/estado")
	public ResponseEntity<?> buscarPorLugarCPEstado(@RequestParam String lugar, @RequestParam String codigoPostal, @RequestParam String estado){
		List<ServicioBancario> servicios = bancarioService.buscarPorLugarCPEstado(lugar, codigoPostal, estado);
		return new ResponseEntity<List<ServicioBancario>>(servicios, HttpStatus.OK);
	}
	
	/**
	 * Endpoint para buscar Servicios Bancarios Banamex disponibles en el Lugar, Codigo Postal, Estado y Servicio
	 * @param lugar Ubicación de la sucursal
	 * @param codigoPostal  
	 * @param estado 
	 * @param servicio Servicio Bancario Banamex
	 * @return Lista de Servicios Bancarios Banamex encontrados en el lugar con codigo postal, estado y Servicio Bancario Banamex ingresado
	 * @author RaulRuvalcaba 31/12/2021
	 */
	@GetMapping("/buscar/lugar/codigoPostal/estado/servicio")
	public ResponseEntity<?> buscarPorLugarCPEstadoSucursal(@RequestParam String lugar, @RequestParam String codigoPostal, @RequestParam String estado, @RequestParam String servicio){
		List<ServicioBancario> servicios = bancarioService.buscarPorLugarCPEstadoServicio(lugar, codigoPostal, estado, servicio);
		return new ResponseEntity<List<ServicioBancario>>(servicios, HttpStatus.OK);
	}
	
	/**
	 * Endpoint para buscar Servicios Bancarios Banamex en base al servicio solicitado
	 * @param servicio Servicio Bancario Banamex
	 * @return Lista de Servicios Bancarios Banamex encontrados en base al servicio buscado
	 * @author RaulRuvalcaba 31/12/2021
	 */
	@GetMapping("/buscar/servicio")
	public ResponseEntity<?> buscarPorServicio(@RequestParam String servicio){
		List<ServicioBancario> servicios = bancarioService.findByServicioDetalle(servicio);
		return new ResponseEntity<List<ServicioBancario>>(servicios, HttpStatus.OK);
	}
	
	/**
	 * Endpint para consultar todos los Servicios Bancarios Banamex disponibles con su codigo de servicio
	 * @return Lista de nombres de Servicios Bancarios Banamex disponibles con codigo de servicio
	 * @author RaulRuvalcaba 31/12/2021
	 */
	@GetMapping("/listar")
	public ResponseEntity<?> listarSercviciosDisponibles(){
		List<String> servicios = bancarioService.listarServicios();
		return new ResponseEntity<List<String>>(servicios, HttpStatus.OK);
	}

}
