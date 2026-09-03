package pe.utec.fullstack.workshop.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "store")
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToMany(mappedBy = "store")
    private List<WarehouseEntity> warehouses;

    private String name;

    private String logo;

    private String type;

    private Boolean enabled;

    private Integer createdBy;

    private LocalDateTime createdAt;

    private Integer updatedBy;

    private LocalDateTime updatedAt;
}
