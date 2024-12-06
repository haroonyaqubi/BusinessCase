package BusinessCase.fr.businessCase.entity;

import BusinessCase.fr.businessCase.json_views.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name="users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Column(nullable = false)
    @JsonView(JsonViews.UserShowView.class)
    private String email;

    @JsonView(JsonViews.UserShowView.class)
    private String firstName;

    @JsonView(JsonViews.UserShowView.class)
    private String lastName;

    @JsonView(JsonViews.UserShowView.class)
    private String phone;

    @Column(nullable = false)
    private String roles;

    @Column(nullable = false)
    private String password;

    private String activationCode;

    private LocalDateTime activationCodeSentAt;

    private LocalDate birthAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<Localisation> localisations = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Favorite> favorites = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserLocalisation> userLocalisations = new ArrayList<>();

    @OneToMany(mappedBy = "userFrom")
    private List<UserReview> userFromReviews;

    @OneToMany(mappedBy = "userTo")
    private List<UserReview> userToReviews;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        JSONArray roles = new JSONArray(this.roles);
        roles.forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        });
        return authorities;
    }
    @Override
    public String getUsername() {
        return this.email;
    }

}
