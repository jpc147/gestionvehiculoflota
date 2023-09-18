package com.gestion.vehiculos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestion.vehiculos.Entity.Carro;




@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {
	
	Carro findByIdCarro(Integer idCarro);
	
	@Query(value = "select c from carro c inner join viaje v on c.id_carro = v.id_carro where v.data_entrega is null", nativeQuery = true)
	List<Carro> findCarrosEntragados();

}
