package BusinessCase.fr.businessCase.embadded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class UserChargingStation implements Serializable {

    @Column(name = "charging_station_id")
    private String chargingStationId;

    @Column(name = "user_id")
    private String userId;
}
