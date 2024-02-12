package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class GanaderiaList {

    private Long id_ganaderia;
    private String nombre_ganaderia;
    private String dueño;
    private Integer numero_animales;
    
}
