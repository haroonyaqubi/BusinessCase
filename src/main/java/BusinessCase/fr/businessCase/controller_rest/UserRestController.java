package BusinessCase.fr.businessCase.controller_rest;

import BusinessCase.fr.businessCase.Service.UserService;
import BusinessCase.fr.businessCase.dto.User.UserUpdateDTO;
import BusinessCase.fr.businessCase.entity.User;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserRestController {

    private UserService userService;

    @PutMapping("/{uuid}")
    public User update(@Valid @RequestBody UserUpdateDTO dto, @PathVariable String uuid) {
        return userService.update(dto, uuid);
    }
}
