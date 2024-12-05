package BusinessCase.fr.businessCase.dto.ChargingStation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChargingStationUpdateDTO {

    @NotBlank(message = "UUID must not be blank")
    private String uuid;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotNull(message = "Hourly rate must not be null")
    private int hourlyRate;

    @NotBlank(message = "Access directives must not be blank")
    private String accessDirectives;

    @NotNull(message = "OnFoot value must not be null")
    private boolean onFoot;

    @NotNull(message = "Power ID must not be null")
    private Long powerId;

    @NotNull(message = "Localisation ID must not be null")
    private Long localisationId;
}
