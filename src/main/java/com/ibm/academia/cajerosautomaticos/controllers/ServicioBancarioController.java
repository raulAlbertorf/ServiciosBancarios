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
	
	@GetMapping("/buscar")
	public ResponseEntity<?> buscarServicioPorLugar(@RequestParam String lugar){
		List<ServicioBancario> servicios = bancarioService.buscarPorLugar(lugar);
		return new ResponseEntity<List<ServicioBancario>>(servicios, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/direccion/esp")
	public ResponseEntity<?> buscarServicioPorDireccionEspañol(@RequestParam String direccion){
		List<ServicioBancario> servicios = bancarioService.buscarPorDireccionEspannol(direccion);
		return new ResponseEntity<List<ServicioBancario>>(servicios, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/lugar/codigoPostal/estado")
	public ResponseEntity<?> buscarPorLugarCPEstado(@RequestParam String lugar, @RequestParam String codigoPostal, @RequestParam String estado){
		List<ServicioBancario> servicios = bancarioService.buscarPorLugarCPEstado(lugar, codigoPostal, estado);
		return new ResponseEntity<List<ServicioBancario>>(servicios, HttpStatus.OK);
	}
	
	@GetMapping("/buscar/lugar/codigoPostal/estado/servicio")
	public ResponseEntity<?> buscarPorLugarCPEstadoSucursal(@RequestParam String lugar, @RequestParam String codigoPostal, @RequestParam String estado, @RequestParam String servicio){
		List<ServicioBancario> servicios = bancarioService.buscarPorLugarCPEstadoServicio(lugar, codigoPostal, estado, servicio);
		return new ResponseEntity<List<ServicioBancario>>(servicios, HttpStatus.OK);
	}

}
