package com.gestion.vehiculos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gestion.vehiculos.Entity.Usuarios;
import java.util.List;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {
	
	@Query(value = "select * from usuarios  where user_name = :username and user_pass = :password", nativeQuery = true)
	Usuarios findByUsernameAndPasswordUsuarios(String username, String password);
	
	public Usuarios findByUsername(String username);

}
