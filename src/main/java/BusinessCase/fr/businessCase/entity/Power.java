package BusinessCase.fr.businessCase.entity;

import BusinessCase.fr.businessCase.json_views.JsonViews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Power {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.UserShowView.class)
    private Long id;

    @Column(nullable = false)
    @JsonView(JsonViews.UserShowView.class)
    private double value;

    @OneToMany(mappedBy = "power")
    @JsonIgnore  // Ignore chargingStations field in the JSON response
    private List<ChargingStation> chargingStations = new ArrayList<>();

}
