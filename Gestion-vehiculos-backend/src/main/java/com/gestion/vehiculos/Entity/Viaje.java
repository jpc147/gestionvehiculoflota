package com.gestion.vehiculos.Entity;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Viaje")
public class Viaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_empleado")
	private Empleado empleado;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "id_carro")
	private Carro carro;

	@Column(name = "dataRetirada")
	private Date fechaInicio;

	@Column(name = "dataEntrega")
	private Date fechaFin;

	public Viaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Viaje(Integer id, Empleado empleado, Carro carro, Date fechaInicio, Date fechaFin) {
		super();
		this.id = id;
		this.empleado = empleado;
		this.carro = carro;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Viaje [id=" + id + ", empleado=" + empleado + ", carro=" + carro + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + "]";
	}

}
