package BusinessCase.fr.businessCase.dto.User;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserLoginDTO {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
