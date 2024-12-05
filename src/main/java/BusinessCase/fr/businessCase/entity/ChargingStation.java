package BusinessCase.fr.businessCase.entity;

import BusinessCase.fr.businessCase.json_views.JsonViews;
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
public class ChargingStation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(JsonViews.ChargingView.class)
    private String uuid;

    @Column(nullable = false)
    @JsonView(JsonViews.ChargingView.class)
    private String name;

    @Column(nullable = false)
    @JsonView(JsonViews.ChargingView.class)
    private int hourlyRate;

    @Column(nullable = false)
    @JsonView(JsonViews.ChargingView.class)
    private String accessDirectives;

    @Column(nullable = false)
    @JsonView(JsonViews.ChargingView.class)
    private boolean onFoot;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Localisation localisation;

    @ManyToOne
    @JoinColumn(name = "power_id", nullable = false)
    private Power power;

    @OneToMany(mappedBy = "chargingStation")
    private List<Media> medias = new ArrayList<>();

    @OneToMany(mappedBy = "chargingStation")
    private List<Favorite> favorites = new ArrayList<>();

    @OneToMany(mappedBy = "chargingStation")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "chargingStation")
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "chargingStation")
    private List<HourlyRate> hourlyRates = new ArrayList<>();

}
