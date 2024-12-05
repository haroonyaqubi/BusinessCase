package BusinessCase.fr.businessCase.controller_rest;

import BusinessCase.fr.businessCase.Service.ChargingStationService;
import BusinessCase.fr.businessCase.dto.ChargingStation.ChargingStationCreateDTO;
import BusinessCase.fr.businessCase.dto.ChargingStation.ChargingStationUpdateDTO;
import BusinessCase.fr.businessCase.entity.ChargingStation;
import BusinessCase.fr.businessCase.json_views.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/chargingstation")
public class ChargingStationRestController {

    private ChargingStationService chargingStationService;

    @GetMapping
    @JsonView(JsonViews.ChargingView.class)
    public List<ChargingStation> list() {
        return chargingStationService.list();
    }

    @PostMapping
    @JsonView(JsonViews.ChargingView.class)
    public ChargingStation create(@RequestBody ChargingStationCreateDTO dto) {
        return chargingStationService.create(dto);
    }

    @PutMapping("/{uuid}")
    @JsonView(JsonViews.ChargingView.class)
    public ChargingStation update(@RequestBody ChargingStationUpdateDTO dto, @PathVariable String uuid) {
        return chargingStationService.update(dto, uuid);
    }

    @DeleteMapping("/{uuid}")
    public Boolean delete(@PathVariable String uuid) {
        return chargingStationService.delete(uuid);
    }

    @GetMapping("/{uuid}")
    @JsonView(JsonViews.ChargingView.class)
    public ChargingStation show(@PathVariable String uuid) {
        if (uuid == null || uuid.isBlank()) {
            throw new IllegalArgumentException("UUID must not be null or blank");
        }
        return chargingStationService.findOneById(uuid);
    }
}
