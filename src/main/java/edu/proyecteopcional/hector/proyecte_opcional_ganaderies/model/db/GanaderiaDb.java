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
@Table(name= "ganaderias")
public class GanaderiaDb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ganaderia;
    private String nombre_ganaderia;
    private String dueño;
    private Integer numero_animales;
    
}
