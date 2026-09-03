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
@Table(name = "client")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToMany(mappedBy = "client")
    private List<AddressEntity> addresses;

    private String firstName;

    private String lastName;

    private String dni;

    private Boolean enabled;

    private Integer createdBy;

    private LocalDateTime createdAt;

    private Integer updatedBy;

    private LocalDateTime updatedAt;
}
