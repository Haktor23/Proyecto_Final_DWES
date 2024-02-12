package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv;

import java.util.Optional;

import org.springframework.data.domain.Pageable;

import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.db.AnimalesDb;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto.AnimalesList;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto.PaginaDto;

public interface AnimalesService {

    PaginaDto<AnimalesList> findAllPage(Pageable pageable);

    public Optional<AnimalesDb> getAnimalesByCrotal(Long id);

    public AnimalesDb createAnimales(AnimalesDb animals);

}
