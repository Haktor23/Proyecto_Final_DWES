package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.security.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.security.entity.RolDb;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.security.entity.enums.RolNombre;

import java.util.Optional;


public interface RolRepository extends JpaRepository<RolDb, Integer>{
    Optional<RolDb> findByNombre(RolNombre rolNombre);   
}
