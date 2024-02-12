package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnimalesEdit {

    private Long crotal;
    private Integer numero;
    private String nombre;
    private Integer edad;
    private Integer guarismo;
}
