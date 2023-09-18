package com.gestion.vehiculos.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.vehiculos.Entity.*;
import com.gestion.vehiculos.service.GestionFlotaService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ControladorGestionFlota {

	@Autowired
	private GestionFlotaService gestionFlotaService;

	@PostMapping("/empleados")
	public ResponseEntity<String> agregarEmpleado(@RequestBody Empleado empleado) throws Exception {
		Empleado empleadoGuardado = gestionFlotaService.guardarEmpleado(empleado);

		if (empleadoGuardado != null) {
			return new ResponseEntity<String>("El epleado fue creado satisfactoriamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Hubo un error al momento de guardar los datos",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("empleados/{idempleados}")
	public ResponseEntity<String> exluirEmpleado(@PathVariable("idempleados") Integer idEmpleado) throws Exception {
		gestionFlotaService.excluirEmpleado(idEmpleado);
		return new ResponseEntity<String>("El empleado se excluido de forma satisfactoria", HttpStatus.OK);
	}

	@GetMapping("/empleados")
	public ResponseEntity<List<Empleado>> listarEmpleados() throws Exception {
		List<Empleado> listaEmpleados = new ArrayList<Empleado>();
		listaEmpleados = gestionFlotaService.listarEmpleados();
		return new ResponseEntity<List<Empleado>>(listaEmpleados, HttpStatus.OK);
	}

	@PostMapping("/carros")
	public ResponseEntity<String> agregarCarro(@RequestBody Carro carro) throws Exception {
		Carro guardarCarro = gestionFlotaService.guardarCarro(carro);

		if (guardarCarro != null) {
			return new ResponseEntity<String>("El carro fue guardado de forma exitosa", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Hubo un error al momento de guardar los datos",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/carros/{idCarro}")
	public ResponseEntity<String> excluirCarro(@PathVariable("idCarro") Integer idCarro) throws Exception {
		gestionFlotaService.excluirCarro(idCarro);
		return new ResponseEntity<String>("El carro fue excluido de forma satisfactoria", HttpStatus.OK);
	}

	@GetMapping("/carros")
	public ResponseEntity<List<Carro>> listarTodosLosCarros() throws Exception {
		List<Carro> listarCarros = gestionFlotaService.listarCarros();
		return new ResponseEntity<List<Carro>>(listarCarros, HttpStatus.OK);
	}

	@GetMapping("/carros/retirados")
	public ResponseEntity<List<Carro>> listarCarrosEnUso() throws Exception {
		List<Carro> ListarCarrosEnUso = gestionFlotaService.listarCarrosEnUso();
		return new ResponseEntity<List<Carro>>(ListarCarrosEnUso, HttpStatus.OK);
	}

	@PostMapping("/viaje/{idempleados}/{idCarro}/")
	public ResponseEntity<String> retirarUnCarro(@PathVariable("idempleados") Integer idempleados,
			@PathVariable("idCarro") Integer idCarro) throws Exception {
		Viaje viaje = new Viaje();
		viaje = gestionFlotaService.crearViaje(idempleados, idCarro);

		if (viaje != null) {
			return new ResponseEntity<String>("El vehiculo se ha retirado de forma exitosa", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Ocurrio un error al momento de retirar el vehiculo",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/viaje/{idempleados}/{idCarro}/")
	public ResponseEntity<String> devolucionCarroEmpleado(@PathVariable("idempleados") Integer idempleados,
			@PathVariable("idCarro") Integer idCarro) throws Exception {
		gestionFlotaService.cancelacionViaje(idempleados, idCarro);
		return new ResponseEntity<String>("El vehiculo fue devuelto de forma exitosa", HttpStatus.OK);

	}

	@GetMapping("/viaje/realizadas/{mes}/{ano}/")
	public ResponseEntity<List<Viaje>> viajesTerminados(@PathVariable("mes") Integer mes,
			@PathVariable("ano") Integer anio) throws Exception {
		List<Viaje> listaCiajesCulminados = new ArrayList<Viaje>();
		listaCiajesCulminados = gestionFlotaService.ListarViajesCulminadosXFechaYAnio(mes, anio);
		return new ResponseEntity<List<Viaje>>(listaCiajesCulminados, HttpStatus.OK);
	}
}
