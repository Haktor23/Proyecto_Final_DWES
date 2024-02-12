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

import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.db.GanaderiaDb;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto.GanaderiaList;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto.PaginaDto;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.GanaderiaService;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.repository.GanaderiaRepository;

@RestController
@RequestMapping("/api/ganaderia/")
public class GanaderiaRestController {

    private final GanaderiaService ganaderiaService;

    public GanaderiaRestController(GanaderiaService ganaderiaService) {
        this.ganaderiaService = ganaderiaService;
    }

    @GetMapping("/ganaderias")
    public PaginaDto<GanaderiaList> getAllGanaderia(Pageable pageable) {
        return ganaderiaService.findAllPage(pageable);
    }

    @GetMapping("/ganaderia/{id}")
    public ResponseEntity<GanaderiaDb> getGanaderiaById(@PathVariable("id") Long id) {
        Optional<GanaderiaDb> ganaderia = ganaderiaService.getGanaderiaById(id);
        return ganaderia.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    

    /*@PostMapping("/crearganaderia")
    public ResponseEntity<GanaderiaDb> createGanaderia(@RequestBody GanaderiaDb ganaderiaDb) {
        GanaderiaDb createdGanaderia = ganaderiaService.createGanaderia(ganaderiaDb);
        return new ResponseEntity<>(createdGanaderia, HttpStatus.CREATED);
    }*/

     @Autowired
    private GanaderiaRepository ganaderiaRepository;

    @PostMapping("/crearganaderia")
    public ResponseEntity<?> createGanaderia(@RequestBody GanaderiaDb ganaderia) {
        try {
            GanaderiaDb nuevaGanaderia = ganaderiaRepository.save(ganaderia);
            return new ResponseEntity<>(nuevaGanaderia, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la ganadería: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

