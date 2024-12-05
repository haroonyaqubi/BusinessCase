package BusinessCase.fr.businessCase.dto.ChargingStation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChargingStationCreateDTO {

    @NotBlank
    private String name;

    @NotNull
    private int hourlyRate;

    @NotBlank
    private String accessDirectives;

    @NotNull
    private boolean onFoot;

    @NotNull
    private Long powerId;

    @NotNull
    private Long localisationId;

}
