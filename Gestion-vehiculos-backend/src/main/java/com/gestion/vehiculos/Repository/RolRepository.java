package com.gestion.vehiculos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestion.vehiculos.Entity.Rol;

public interface RolRepository extends JpaRepository<Rol,Long> {
}
