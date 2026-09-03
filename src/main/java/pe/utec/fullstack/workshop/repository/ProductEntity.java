package pe.utec.fullstack.workshop.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    private Double purchasePrice;

    private Double sellPrice;

    private String description;

    private Boolean enabled;

    private Integer createdBy;

    private LocalDateTime createdAt;

    private Integer updatedBy;

    private LocalDateTime updatedAt;
}
