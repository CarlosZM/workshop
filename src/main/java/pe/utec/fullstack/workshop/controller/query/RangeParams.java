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
public class RangeParams {

    @DecimalMin(value = "-90.00")
    @DecimalMax(value = "90.00")
    private Long lte;

    @DecimalMin(value = "-90.00")
    @DecimalMax(value = "90.00")
    private Long gte;

    @DecimalMin(value = "-90.00")
    @DecimalMax(value = "90.00")
    private Long eq;
}
