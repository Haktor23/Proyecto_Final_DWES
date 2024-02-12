package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.db.AnimalesDb;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto.AnimalesList;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto.PaginaDto;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.AnimalesService;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.repository.AnimalesRepository;

@RestController
@RequestMapping("/api/animal/")
public class AnimalesRestController {

    private final AnimalesService animalesService;

    public AnimalesRestController(AnimalesService animalesService) {
        this.animalesService = animalesService;
    }

    @GetMapping("/animales")
    public PaginaDto<AnimalesList> getAllAnimales(Pageable pageable) {
        return animalesService.findAllPage(pageable);
    }

    @GetMapping("/animales/{id}")
    public ResponseEntity<AnimalesDb> getAnimalesByCrotal(@PathVariable("id") Long id) {
        Optional<AnimalesDb> animal = animalesService.getAnimalesByCrotal(id);
        return animal.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Autowired
    private AnimalesRepository animalesRepository;

    @PostMapping("/crearanimal")
    public ResponseEntity<?> createAnimal(@RequestBody AnimalesDb animal) {
        try {
            AnimalesDb nuevoAnimal = animalesRepository.save(animal);
            return new ResponseEntity<>(nuevoAnimal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear el animal: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}