package BusinessCase.fr.businessCase.Service;

import BusinessCase.fr.businessCase.Repository.LocalisationRepository;
import BusinessCase.fr.businessCase.Repository.UserRepository;
import BusinessCase.fr.businessCase.Service.interfaces.ServiceInterface;
import BusinessCase.fr.businessCase.dto.User.UserCreateDTO;
import BusinessCase.fr.businessCase.dto.User.UserUpdateDTO;
import BusinessCase.fr.businessCase.entity.Localisation;
import BusinessCase.fr.businessCase.entity.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService , ServiceInterface<User, String, UserCreateDTO, UserUpdateDTO> {

    private UserRepository userRepository;
    private LocalisationRepository localisationRepository;

    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User create(UserCreateDTO o) {
        User user = new User();
        user.setRoles("[\"ROLE_USER\"]");
        user.setCreatedAt(LocalDateTime.now());
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPhone(o.getPhone());
        user.setPassword(passwordEncoder.encode(o.getPassword()));
        user.setEmail(o.getEmail());
        user.setFirstName(o.getFirstName());
        user.setLastName(o.getLastName());
        user.setBirthAt(o.getBirthAt());
        user.setActivationCodeSentAt(LocalDateTime.now());
        // Send mail ? mailerService.sendActivationCode(user);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User update(UserUpdateDTO o, String id) {
        User user = findOneById(id);
        user.setPhone(o.getPhone());
        user.setBirthAt(o.getBirthAt());
        user.setFirstName(o.getFirstName());
        user.setLastName(o.getLastName());
        return userRepository.saveAndFlush(user);
    }

    @Override
    public Boolean delete(String uuid) {
        try {
            User user = findOneById(uuid);
            user.setPhone(null);
            user.setBirthAt(null);
            user.setLastName(null);
            user.setFirstName(null);
            user.setEmail("Utilisateur supprimé");
            List<Localisation> localisations = user.getLocalisations();
            for (Localisation localisation : localisations) {
                if (localisation != null) {
                    localisation.setUser(null);
                    localisationRepository.save(localisation);
                }
            }
            userRepository.saveAndFlush(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User findOneById(String id) {
    return userRepository.findById(id)
            .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findUserByEmailAndActivationCodeIsNull(username)
                .orElseThrow(() -> new UsernameNotFoundException("Echec de la connexion"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getAuthorities()
        );
    }
}