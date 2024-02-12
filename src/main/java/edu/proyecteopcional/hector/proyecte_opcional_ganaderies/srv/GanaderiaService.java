package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv;

import java.util.Optional;
import org.springframework.data.domain.Pageable;

import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.db.GanaderiaDb;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto.GanaderiaList;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto.PaginaDto;


public interface GanaderiaService {

    PaginaDto<GanaderiaList> findAllPage(Pageable pageable);

    public Optional<GanaderiaDb> getGanaderiaById(Long id);

    public GanaderiaDb createGanaderia(GanaderiaDb ganaderia);

}
