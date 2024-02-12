package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.db.AnimalesDb;
@Repository
public interface AnimalesRepository extends JpaRepository<AnimalesDb, Long>{

    Page<AnimalesDb> findAll (Pageable pageable);
    
}