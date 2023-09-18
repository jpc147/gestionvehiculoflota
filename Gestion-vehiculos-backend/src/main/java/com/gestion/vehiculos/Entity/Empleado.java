package com.gestion.vehiculos.Entity;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Empleado")
public class Empleado {

	@Id
	@Column(name = "id_empleado")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEempleado;

	@Column(name = "nombre")
	private String nombreEmpleado;

	@Column(name = "matricula")
	private Integer numeroMatricual;

	@JsonManagedReference
	@OneToMany(mappedBy = "empleado")
	private List<Viaje> viajesList;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "empleado")
	private Usuarios usuario;

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(Integer idEempleado, String nombreEmpleado, Integer numeroMatricual, List<Viaje> viajesList) {
		super();
		this.idEempleado = idEempleado;
		this.nombreEmpleado = nombreEmpleado;
		this.numeroMatricual = numeroMatricual;
		this.viajesList = viajesList;
	}

	public Integer getIdEempleado() {
		return idEempleado;
	}

	public void setIdEempleado(Integer idEempleado) {
		this.idEempleado = idEempleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public Integer getNumeroMatricual() {
		return numeroMatricual;
	}

	public void setNumeroMatricual(Integer numeroMatricual) {
		this.numeroMatricual = numeroMatricual;
	}

	public List<Viaje> getViajesList() {
		return viajesList;
	}

	public void setViajesList(List<Viaje> viajesList) {
		this.viajesList = viajesList;
	}

	@Override
	public String toString() {
		return "Empleado [idEempleado=" + idEempleado + ", nombreEmpleado=" + nombreEmpleado + ", numeroMatricual="
				+ numeroMatricual + ", viajesList=" + viajesList + "]";
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

}
