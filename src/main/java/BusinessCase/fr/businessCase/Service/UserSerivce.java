package BusinessCase.fr.businessCase.Service;

import BusinessCase.fr.businessCase.Service.interfaces.ServiceInterface;
import BusinessCase.fr.businessCase.dto.User.UserCreateDTO;
import BusinessCase.fr.businessCase.dto.User.UserUpdateDTO;
import BusinessCase.fr.businessCase.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserSerivce implements ServiceInterface<User, String, UserCreateDTO, UserUpdateDTO>{


    @Override
    public User update(UserUpdateDTO o, String id) {
        return null;
    }

    @Override
    public User findOneById(String id) {
        return null;
    }

    @Override
    public User create(UserCreateDTO o) {
        return null;
    }

    @Override
    public Boolean delete(String id) {
        return null;
    }
}
