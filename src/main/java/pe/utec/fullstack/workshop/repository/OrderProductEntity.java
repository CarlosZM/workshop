package pe.utec.fullstack.workshop.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_product")
public class OrderProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private OrderEntity order;

    private Integer productId;

    private String name;

    private Double purchasePrice;

    private Double sellPrice;

    private String description;

    private Double quantity;

    private Boolean enabled;
}
