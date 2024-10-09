package BusinessCase.fr.businessCase.entity;

import BusinessCase.fr.businessCase.embadded.UserChargingStation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Favorite {

    @EmbeddedId
    private UserChargingStation id;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "charging_station_id", insertable = false, updatable = false)
    private ChargingStation chargingStation;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
}
