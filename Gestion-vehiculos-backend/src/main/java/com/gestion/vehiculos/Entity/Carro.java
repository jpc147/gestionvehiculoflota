package com.gestion.vehiculos.Entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Carro")
public class Carro {

	@Id
	@Column(name = "id_carro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCarro;

	@Column(name = "modelo")
	private String modeloCarro;

	@Column(name = "marca")
	private String marcaCarro;

	@Column(name = "dataFabricacao")
	private Date fechaFabricacion;

	@JsonManagedReference
	@OneToMany(mappedBy = "carro")
	private List<Viaje> viajeList;

	public Carro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carro(Integer idCarro, String modeloCarro, String marcaCarro, Date fechaFabricacion, List<Viaje> viajeList) {
		super();
		this.idCarro = idCarro;
		this.modeloCarro = modeloCarro;
		this.marcaCarro = marcaCarro;
		this.fechaFabricacion = fechaFabricacion;
		this.viajeList = viajeList;
	}

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getMarcaCarro() {
		return marcaCarro;
	}

	public void setMarcaCarro(String marcaCarro) {
		this.marcaCarro = marcaCarro;
	}

	public Date getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(Date fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}

	public List<Viaje> getViajeList() {
		return viajeList;
	}

	public void setViajeList(List<Viaje> viajeList) {
		this.viajeList = viajeList;
	}

	@Override
	public String toString() {
		return "Carro [idCarro=" + idCarro + ", modeloCarro=" + modeloCarro + ", marcaCarro=" + marcaCarro
				+ ", fechaFabricacion=" + fechaFabricacion + ", viajeList=" + viajeList + "]";
	}

}
