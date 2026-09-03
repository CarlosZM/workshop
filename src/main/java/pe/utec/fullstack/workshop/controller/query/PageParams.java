package pe.utec.fullstack.workshop.controller.query;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageParams {

    @DecimalMin("0.0")
    @DecimalMax("20.0")
    private Integer size;

    @DecimalMin("1.0")
    @DecimalMax("999.0")
    private Integer page;
}
