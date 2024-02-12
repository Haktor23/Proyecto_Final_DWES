package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.db.GanaderiaDb;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto.GanaderiaList;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto.PaginaDto;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.GanaderiaService;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.mapper.GanaderiaMapper;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.repository.GanaderiaRepository;

@Service
public class GanaderiaImplService implements GanaderiaService {

    private final GanaderiaRepository ganaderiaRepository;

    public GanaderiaImplService(GanaderiaRepository ganaderiaRepository) {
        this.ganaderiaRepository = ganaderiaRepository;
    }

    public PaginaDto<GanaderiaList> findAllPage(Pageable pageable) {
        Page<GanaderiaDb> paginaGanaderiaDb = ganaderiaRepository.findAll(pageable);
        List<GanaderiaList> ganaderiaLists = GanaderiaMapper.INSTANCE
                .ganaderiaDbListToGanaderiaList(paginaGanaderiaDb.getContent());
        return new PaginaDto<>(
            paginaGanaderiaDb.getNumber(),
            paginaGanaderiaDb.getSize(),
            paginaGanaderiaDb.getTotalElements(),
            paginaGanaderiaDb.getTotalPages(),
            ganaderiaLists,
            paginaGanaderiaDb.getSort());
    }

    @Override
    public Optional<GanaderiaDb> getGanaderiaById(Long id) {
        return ganaderiaRepository.findById(id);
    }

    @Override
    public GanaderiaDb createGanaderia(GanaderiaDb ganaderia) {
        return ganaderiaRepository.save(ganaderia);
    }

   

   

}
