package pe.utec.fullstack.workshop.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.utec.fullstack.workshop.domain.business.DeliveryStatus;
import pe.utec.fullstack.workshop.domain.business.OrderType;
import pe.utec.fullstack.workshop.domain.business.PaymentMethod;
import pe.utec.fullstack.workshop.domain.business.PaymentStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String number;

    private Integer quantity;

    private Double price;

    private Double taxes;

    private Double deliveryFee;

    @Enumerated(EnumType.STRING)
    private PaymentMethod payment;

    @Enumerated(EnumType.STRING)
    private OrderType type;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @OneToMany(mappedBy = "order")
    private List<OrderProductEntity> products;

    private Boolean enabled;

    private Integer createdBy;

    private LocalDateTime createdAt;

    private Integer updatedBy;

    private LocalDateTime updatedAt;
}
