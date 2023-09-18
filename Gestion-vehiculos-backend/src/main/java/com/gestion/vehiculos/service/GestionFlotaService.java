package com.gestion.vehiculos.service;

import java.util.List;

import com.gestion.vehiculos.Entity.Carro;
import com.gestion.vehiculos.Entity.Empleado;
import com.gestion.vehiculos.Entity.Viaje;

public interface GestionFlotaService {
	
	public Empleado guardarEmpleado(Empleado empleado) throws Exception;
	public void excluirEmpleado(Integer idEmpleado) throws Exception;
	public List<Empleado> listarEmpleados() throws Exception;
	public Carro guardarCarro(Carro caroo) throws Exception;
	public void excluirCarro(Integer idCarro) throws Exception;
	public List<Carro> listarCarros() throws Exception;
	public List<Carro> listarCarrosEnUso() throws Exception;
	public Viaje crearViaje(Integer idEmpleado, Integer IdCarro) throws Exception;
	public void cancelacionViaje(Integer idEmpleado, Integer IdCarro) throws Exception;
	public List<Viaje> ListarViajesCulminadosXFechaYAnio(Integer mes, Integer anio) throws Exception;

}
