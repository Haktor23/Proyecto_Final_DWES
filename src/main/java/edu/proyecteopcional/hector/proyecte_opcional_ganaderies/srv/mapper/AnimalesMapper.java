package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.srv.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.db.AnimalesDb;
import edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto.AnimalesList;


@Mapper
public interface AnimalesMapper {
    AnimalesMapper INSTANCE = Mappers.getMapper(AnimalesMapper.class);

    AnimalesList animalesDbToAnimalesList(AnimalesDb animalesDb);
   
    List<AnimalesList> animalesDbListToAnimalesList(List<AnimalesDb> animalesDb);

    List<AnimalesDb> animalesDbToAnimalesList(List<AnimalesDb> animalesList);
}