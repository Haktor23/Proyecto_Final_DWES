package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.db.GanaderiaDb;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto.GanaderiaList;

@Mapper
public interface GanaderiaMapper {
    GanaderiaMapper INSTANCE = Mappers.getMapper(GanaderiaMapper.class);

    GanaderiaList ganaderiaDbToGanaderiaList(GanaderiaDb ganaderiaDb);

    List<GanaderiaList> ganaderiaDbListToGanaderiaList(List<GanaderiaDb> ganaderiaDb);

    List<GanaderiaDb> ganaderiaDbToGanaderiaList(List<GanaderiaDb> ganaderiaList);
}