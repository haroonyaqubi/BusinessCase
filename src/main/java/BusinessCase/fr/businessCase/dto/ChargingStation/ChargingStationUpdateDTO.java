package BusinessCase.fr.businessCase.dto.ChargingStation;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChargingStationUpdateDTO {

    @NotBlank
    private String name;

    @NotBlank
    private int hourlyRate;

    @NotBlank
    private String accessDirectives;

    @NotBlank
    private boolean onFoot;
}
