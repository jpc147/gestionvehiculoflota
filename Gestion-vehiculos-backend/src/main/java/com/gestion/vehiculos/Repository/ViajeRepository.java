package com.gestion.vehiculos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestion.vehiculos.Entity.Viaje;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Integer> {
	
	@Query(value = "select * from viaje where to_char(data_entrega,'yyyy-MM') = :anioMes", nativeQuery = true)
	List<Viaje> viajesTerminadosPorMesYAnio(String anioMes);

}
