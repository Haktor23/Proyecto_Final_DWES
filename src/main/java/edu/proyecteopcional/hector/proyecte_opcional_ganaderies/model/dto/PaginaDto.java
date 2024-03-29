package edu.proyecteopcional.hector.proyecte_opcional_ganaderies.model.dto;


import java.util.List;
import org.springframework.data.domain.Sort;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaginaDto<T> {
    int number;
    int size;
    long totalElements;
    int totalPages;
    List<T> content;
    Sort sort;
}