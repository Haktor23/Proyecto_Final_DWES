package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.db.GanaderiaDb;
@Repository
public interface GanaderiaRepository extends JpaRepository<GanaderiaDb, Long>{

    Page<GanaderiaDb> findAll (Pageable pageable);
    
}