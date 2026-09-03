package pe.utec.fullstack.workshop.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.utec.fullstack.workshop.domain.business.Role;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String userName;

    private String password;

    private Boolean enabled;

    @Enumerated(EnumType.STRING)
    private List<Role> roles;

    private LocalDateTime lastSignIn;

    private Integer createdBy;

    private LocalDateTime createdAt;

    private Integer updatedBy;

    private LocalDateTime updatedAt;
}
