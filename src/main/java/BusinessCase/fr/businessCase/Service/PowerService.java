package BusinessCase.fr.businessCase.Service;

import BusinessCase.fr.businessCase.Repository.PowerRepository;
import BusinessCase.fr.businessCase.Service.interfaces.ServiceListInterface;
import BusinessCase.fr.businessCase.dto.Power.PowerCreateDTO;
import BusinessCase.fr.businessCase.dto.Power.PowerUpdateDTO;
import BusinessCase.fr.businessCase.entity.Power;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PowerService implements ServiceListInterface<Power, Long, PowerCreateDTO, PowerUpdateDTO> {

    private PowerRepository powerRepository;

    @Override
    public Power create(PowerCreateDTO dto) {
        Power power = new Power();
        power.setValue(dto.getValue());
        return powerRepository.saveAndFlush(power);
    }

    @Override
    public Power update(PowerUpdateDTO dto, Long id) {
        Power power = findOneById(id);
        power.setValue(dto.getValue());
        return powerRepository.saveAndFlush(power);
    }

    @Override
    public Boolean delete(Long id) {
        try {
            Power power = findOneById(id);
            powerRepository.delete(power);
        } catch (EntityNotFoundException e) {
            return false;
        }
        return true;
    }

    @Override
    public Power findOneById(Long id) {
        return powerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Power entity not found"));
    }

    @Override
    public List<Power> list() {
        return powerRepository.findAll();
    }
}
