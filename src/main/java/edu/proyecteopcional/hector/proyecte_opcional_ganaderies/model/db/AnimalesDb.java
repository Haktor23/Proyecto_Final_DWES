package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.db;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "animales")
public class AnimalesDb {
    @Id
    private Long crotal;
    private Integer numero;
    private String nombre;
    private Integer edad;
    private Integer guarismo;
}
