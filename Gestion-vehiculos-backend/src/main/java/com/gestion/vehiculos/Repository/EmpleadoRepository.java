package com.gestion.vehiculos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.vehiculos.Entity.Empleado;
import java.util.List;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	
	Empleado saveAndFlush(Empleado empleado);
	Empleado findByIdEempleado(Integer idEempleado);
	
}
