package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.security.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.security.entity.RolDb;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.security.entity.enums.RolNombre;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.security.repository.RolRepository;
import jakarta.validation.constraints.NotNull;

@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public Optional<RolDb> getByRolNombre(RolNombre rolNombre) {
        return rolRepository.findByNombre(rolNombre);
    }

    public void save(@NotNull RolDb rol) {
        rolRepository.save(rol);
    }
}
