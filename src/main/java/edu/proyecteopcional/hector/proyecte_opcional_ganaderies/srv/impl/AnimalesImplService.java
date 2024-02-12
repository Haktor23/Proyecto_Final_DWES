package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.db.AnimalesDb;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto.AnimalesList;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto.PaginaDto;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.AnimalesService;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.mapper.AnimalesMapper;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.repository.AnimalesRepository;

@Service
public class AnimalesImplService implements AnimalesService {

    private final AnimalesRepository animalesRepository;

    public AnimalesImplService(AnimalesRepository animalesRepository) {
        this.animalesRepository = animalesRepository;
    }

    public PaginaDto<AnimalesList> findAllPage(Pageable pageable) {
        Page<AnimalesDb> paginaAnimalesDb = animalesRepository.findAll(pageable);
        List<AnimalesList> animalesLists = AnimalesMapper.INSTANCE
                .animalesDbListToAnimalesList(paginaAnimalesDb.getContent());
        return new PaginaDto<>(
                paginaAnimalesDb.getNumber(),
                paginaAnimalesDb.getSize(),
                paginaAnimalesDb.getTotalElements(),
                paginaAnimalesDb.getTotalPages(),
                animalesLists,
                paginaAnimalesDb.getSort());
    }

    @Override
    public Optional<AnimalesDb> getAnimalesByCrotal(Long crotal) {
        return animalesRepository.findById(crotal);
    }

    @Override
    public AnimalesDb createAnimales(AnimalesDb animal) {
        return animalesRepository.save(animal);
    }

}
