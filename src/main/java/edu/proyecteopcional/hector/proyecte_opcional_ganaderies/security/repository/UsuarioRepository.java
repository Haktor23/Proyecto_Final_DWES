package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.security.repository;



import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.security.entity.UsuarioDb;

public interface UsuarioRepository extends JpaRepository<UsuarioDb, Long>{
    Optional<UsuarioDb> findByNickname(String nickname);
    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);
    
}
