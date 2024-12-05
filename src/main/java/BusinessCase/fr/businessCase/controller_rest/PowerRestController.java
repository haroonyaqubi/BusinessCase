package BusinessCase.fr.businessCase.controller_rest;

import BusinessCase.fr.businessCase.Service.PowerService;
import BusinessCase.fr.businessCase.dto.Power.PowerCreateDTO;
import BusinessCase.fr.businessCase.dto.Power.PowerUpdateDTO;
import BusinessCase.fr.businessCase.entity.Power;
import BusinessCase.fr.businessCase.json_views.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/power")
public class PowerRestController {

    private PowerService powerService;

    @GetMapping
    @JsonView(JsonViews.UserShowView.class)
    public List<Power> list() {
        return powerService.list();
    }

    @PostMapping
    public Power create(@RequestBody PowerCreateDTO dto) {
        return powerService.create(dto);
    }

    @PutMapping("/{id}")
    public Power update(@RequestBody PowerUpdateDTO dto, @PathVariable Long id) {
        return powerService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return powerService.delete(id);
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.UserShowView.class)
    public Power show(@PathVariable Long id) {
        return powerService.findOneById(id);
    }
}
