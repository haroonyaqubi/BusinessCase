package BusinessCase.fr.businessCase.dto.Power;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PowerCreateDTO {

    @NotBlank
    private Long id;

    @NotNull
    private double value;

}
