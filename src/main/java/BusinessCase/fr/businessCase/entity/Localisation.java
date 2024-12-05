package BusinessCase.fr.businessCase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Localisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String streetNumber;

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private String zipCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "localisation")
    private List<ChargingStation> chargingStations = new ArrayList<>();

    @OneToMany(mappedBy = "localisation")
    private List<UserLocalisation> userLocalisations = new ArrayList<>();

}
