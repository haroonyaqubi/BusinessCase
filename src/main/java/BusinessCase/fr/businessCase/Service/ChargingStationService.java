package BusinessCase.fr.businessCase.Service;

import BusinessCase.fr.businessCase.Repository.ChargingStationRepository;
import BusinessCase.fr.businessCase.Repository.LocalisationRepository;
import BusinessCase.fr.businessCase.Repository.PowerRepository;
import BusinessCase.fr.businessCase.Service.interfaces.ServiceListInterface;
import BusinessCase.fr.businessCase.dto.ChargingStation.ChargingStationCreateDTO;
import BusinessCase.fr.businessCase.dto.ChargingStation.ChargingStationUpdateDTO;
import BusinessCase.fr.businessCase.entity.ChargingStation;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ChargingStationService implements ServiceListInterface <ChargingStation, String, ChargingStationCreateDTO, ChargingStationUpdateDTO> {


    private ChargingStationRepository chargingStationRepository;
    private PowerRepository powerRepository;
    private LocalisationRepository localisationRepository;


    @Override
    public ChargingStation create(ChargingStationCreateDTO dto) {
        ChargingStation chargingStation = new ChargingStation();
        chargingStation.setName(dto.getName());
        chargingStation.setHourlyRate(dto.getHourlyRate());
        chargingStation.setAccessDirectives(dto.getAccessDirectives());
        chargingStation.setOnFoot(dto.isOnFoot());
        chargingStation.setCreatedAt(LocalDateTime.now());
        chargingStation.setPower(powerRepository.findById(dto.getPowerId()).orElseThrow(()-> new EntityNotFoundException("Not founds")));
        chargingStation.setLocalisation(localisationRepository.findById(dto.getLocalisationId()).orElseThrow(()-> new EntityNotFoundException("Not founds")));

        return chargingStationRepository.saveAndFlush(chargingStation);
    }

    @Override
    public ChargingStation update(ChargingStationUpdateDTO dto, String id) {
        ChargingStation chargingStation = findOneById(id);
        chargingStation.setName(dto.getName());
        chargingStation.setHourlyRate(dto.getHourlyRate());
        chargingStation.setAccessDirectives(dto.getAccessDirectives());
        chargingStation.setOnFoot(dto.isOnFoot());
        chargingStation.setPower(powerRepository.findById(dto.getPowerId()).orElseThrow());
        chargingStation.setLocalisation(localisationRepository.findById(dto.getLocalisationId()).orElseThrow());
        return chargingStationRepository.saveAndFlush(chargingStation);
    }


    @Override
    public Boolean delete(String id) {
        try {
            ChargingStation chargingStation = findOneById(id);
            chargingStation.setName("La borne supprimee");
            chargingStation.setHourlyRate(0);
            chargingStation.setAccessDirectives("");
            chargingStation.setOnFoot(true);
            chargingStationRepository.saveAndFlush(chargingStation);
        } catch (EntityNotFoundException e) {
            return false;
        }

        return true;
    }

    @Override
    public ChargingStation findOneById(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("The given id must not be null or blank");
        }
        return chargingStationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ChargingStation not found for id: " + id));
    }

    @Override
    public List<ChargingStation> list() {
        return chargingStationRepository.findAll();
    }
}
