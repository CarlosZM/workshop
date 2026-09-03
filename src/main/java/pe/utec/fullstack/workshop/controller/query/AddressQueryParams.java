package pe.utec.fullstack.workshop.controller.query;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressQueryParams {

    @Size(min = 3, max = 10)
    private String name;

    @Size(min = 3, max = 10)
    private String alias;

    @Valid
    private RangeParams latitude;

    @Valid
    private RangeParams longitude;

    @Valid
    private PageParams pagination;

    @Size(min = 3, max = 10)
    private String streetName;
}
