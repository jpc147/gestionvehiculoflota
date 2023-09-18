package com.gestion.vehiculos.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

import com.gestion.vehiculos.Entity.Carro;
import com.gestion.vehiculos.Entity.Empleado;
import com.gestion.vehiculos.Entity.Viaje;
import com.gestion.vehiculos.Repository.*;
import com.gestion.vehiculos.service.GestionFlotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionFlotaServicesimpl implements GestionFlotaService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private CarroRepository carroRepository;

	@Autowired
	private ViajeRepository viajeRepository;

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}

	@Override
	public void excluirEmpleado(Integer idEmpleado) throws Exception {
		empleadoRepository.deleteById(idEmpleado);
	}

	@Override
	public List<Empleado> listarEmpleados() {
		return empleadoRepository.findAll();
	}

	@Override
	public Carro guardarCarro(Carro carro) throws Exception {
		return carroRepository.save(carro);
	}

	@Override
	public void excluirCarro(Integer idCarro) throws Exception {
		carroRepository.deleteById(idCarro);
	}

	@Override
	public List<Carro> listarCarros() throws Exception {
		List<Carro> listarCarros = carroRepository.findAll();
		return listarCarros;
	}

	@Override
	public List<Carro> listarCarrosEnUso() throws Exception {
		List<Carro> listaCarrosEnUso = carroRepository.findCarrosEntragados();
		return listaCarrosEnUso;
	}

	@Override
	public Viaje crearViaje(Integer idEmpleado, Integer IdCarro) {
		Viaje viaje = new Viaje();
		Empleado empleado = new Empleado();
		Carro carro = new Carro();

		Calendar calendar = Calendar.getInstance();
		Date fechaInicio = calendar.getTime();

		empleado = empleadoRepository.findByIdEempleado(idEmpleado);
		carro = carroRepository.findByIdCarro(IdCarro);

		viaje.setCarro(carro);
		viaje.setEmpleado(empleado);
		viaje.setFechaInicio(fechaInicio);

		return viajeRepository.save(viaje);
	}

	@Override
	public void cancelacionViaje(Integer idEmpleado, Integer IdCarro) throws Exception {
		Viaje viaje = new Viaje();
		Empleado empleado = new Empleado();
		Carro carro = new Carro();

		Calendar calendar = Calendar.getInstance();
		Date fechaInicio = calendar.getTime();

		empleado = empleadoRepository.findByIdEempleado(idEmpleado);
		carro = carroRepository.findByIdCarro(IdCarro);

		viaje.setCarro(carro);
		viaje.setEmpleado(empleado);
		viaje.setFechaInicio(fechaInicio);

		viajeRepository.delete(viaje);
	}

	@Override
	public List<Viaje> ListarViajesCulminadosXFechaYAnio(Integer mes, Integer anio) throws Exception {
		List<Viaje> listaViajesConcluidos = new ArrayList<Viaje>();
		String mesFiltro = null;
		if(mes.intValue() < 10) {
			mesFiltro = "0"+mes;
		}else {
			mesFiltro = String.valueOf(mes);
		}
		String filtroBusqueda = anio+"-"+mesFiltro;
		listaViajesConcluidos = viajeRepository.viajesTerminadosPorMesYAnio(filtroBusqueda);
		return listaViajesConcluidos;
	}

}
