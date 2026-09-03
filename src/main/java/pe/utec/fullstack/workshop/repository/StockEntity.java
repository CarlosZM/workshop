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
@Table(name = "stock")
public class StockEntity {

    @EmbeddedId
    private StockKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @MapsId("warehouseId")
    @JoinColumn(name = "warehouse_id")
    private WarehouseEntity warehouse;

    private Double availableStock;

    private Double departureStock;

    private Double reservedStock;

    private Boolean enabled;

    private Integer createdBy;

    private LocalDateTime createdAt;

    private Integer updatedBy;

    private LocalDateTime updatedAt;
}
