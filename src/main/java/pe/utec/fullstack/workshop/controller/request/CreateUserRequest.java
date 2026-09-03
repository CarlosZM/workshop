package pe.utec.fullstack.workshop.controller.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import pe.utec.fullstack.workshop.domain.business.Role;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    @NotNull
    @Size(min = 3, max = 255)
    private String userName;

    @NotNull
    @Size(min = 3, max = 255)
    private String password;

    @Size(min = 1)
    @UniqueElements
    private List<Role> roles;
}
