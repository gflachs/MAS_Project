package mas.mockup.masMockup.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mas.mockup.masMockup.persistence.user.UserEntity;
import mas.mockup.masMockup.persistence.user.UserRepository;
import mas.mockup.masMockup.web.database.Users;
import mas.mockup.masMockup.web.database.UserBody;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users getUserByEmail(String email) {

        return EntityToUser(userRepository.findByEmail(email));

    }

    public Users createNewUser(UserBody userBody, String userGroup) throws RuntimeException {

        if (userRepository.existsByEmail(userBody.getEmail())) {
            new RuntimeException();
        }

        UserEntity userEntity = new UserEntity(userBody.getEmail(),
                PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(userBody.getPassword()), userGroup);
        userRepository.save(userEntity);
        return EntityToUser(userEntity);
    }

    private Users EntityToUser(UserEntity userEntity) {

        return new Users(userEntity.getId(), userEntity.getEmail(), userEntity.getPassword(),
                userEntity.getUserGroup());
    }

    private Users EntityToUser(Optional<UserEntity> userEntity) {

        if (!userEntity.isPresent()) {
            return null;
        }
        return EntityToUser(userEntity.get());
    }

}
