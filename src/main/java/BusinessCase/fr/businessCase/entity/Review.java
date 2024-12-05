package BusinessCase.fr.businessCase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private float rating;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ChargingStation chargingStation;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
}
